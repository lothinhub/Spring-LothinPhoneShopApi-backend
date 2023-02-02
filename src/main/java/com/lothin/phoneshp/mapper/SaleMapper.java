package com.lothin.phoneshp.mapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lothin.phoneshp.dto.ProductOrderDTO;
import com.lothin.phoneshp.dto.SaleDTO;
import com.lothin.phoneshp.model.Sale;
import com.lothin.phoneshp.model.SaleDetail;
import com.lothin.phoneshp.service.ProductService;

@Mapper(componentModel = "spring", uses = { ProductService.class })
public interface SaleMapper {

	@Mapping(target = "soldDate", expression = "java(toLocalDateTime(dto.getSoldDate()))")
	Sale toSale(SaleDTO dto);

	@Mapping(target = "sale", source = "sale")
	@Mapping(target = "product", source = "dto.productId")
	SaleDetail toSaleDetail(ProductOrderDTO dto, Sale sale, BigDecimal amount);

	default LocalDateTime toLocalDateTime(String textDateTime) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime dateTime = LocalDateTime.parse(textDateTime, dateTimeFormatter);
		return dateTime;
	}
}
