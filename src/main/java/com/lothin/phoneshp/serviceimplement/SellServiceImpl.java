package com.lothin.phoneshp.serviceimplement;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lothin.phoneshp.dto.ProductOrderDTO;
import com.lothin.phoneshp.dto.SaleDTO;
import com.lothin.phoneshp.mapper.SaleMapper;
import com.lothin.phoneshp.model.Product;
import com.lothin.phoneshp.model.Sale;
import com.lothin.phoneshp.model.SaleDetail;
import com.lothin.phoneshp.repository.ProductRepository;
import com.lothin.phoneshp.repository.SaleDetailRepository;
import com.lothin.phoneshp.repository.SaleRepository;
import com.lothin.phoneshp.service.ProductService;
import com.lothin.phoneshp.service.SellService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SellServiceImpl implements SellService {
	private final SaleRepository saleRepository;
	private final SaleDetailRepository saleDetailRepository;
	private final ProductService productService;
	private final ProductRepository productRepository;
	private final SaleMapper saleMapper;

	@Override
	public void sell(SaleDTO saleDTO) {
		List<ProductOrderDTO> productOrderDTOs = saleDTO.getProducts();
		// validation
		for (ProductOrderDTO orderDTO : productOrderDTOs) {
			// validate stock
			productService.hasAvailableUnit(orderDTO.getProductId(), orderDTO.getUnit());
			// validate sale price
			productService.salePriceIsSet(orderDTO.getProductId());

		}
		// get ordered products from db
		List<Long> productIds = productOrderDTOs.stream()
				.map(ProductOrderDTO::getProductId)
				.toList();

		Map<Long, Product> productMap = productRepository.findAllById(productIds)
				.stream()
				.collect(Collectors.toMap(Product::getId, Function.identity()));

		// save sale
		Sale sale = saleMapper.toSale(saleDTO);
		saleRepository.save(sale);

		// save sale detail
		for (ProductOrderDTO orderDTO : productOrderDTOs) {
			Product product = productMap.get(orderDTO.getProductId());
			SaleDetail saleDetail = saleMapper.toSaleDetail(orderDTO, sale, product.getSalePrice());
			saleDetailRepository.save(saleDetail);

			// update stock
			product.setAvailableUnit(product.getAvailableUnit() - orderDTO.getUnit());
			productRepository.save(product);
		}

	}

}
