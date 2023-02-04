package com.lothin.phoneshp.serviceimplement;

import com.lothin.phoneshp.projections.SaleByDate;
import com.lothin.phoneshp.repository.SaleDetailRepository;
import com.lothin.phoneshp.service.ReportingService;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.time.LocalDate;

@Server
@RequiredArgsConstructor
public class ReportServiceImple implements ReportingService {
    private final SaleDetailRepository saleDetailRepository;

    @Override
    public List<SaleByDate> getProductSoldByDate(LocalDate soldDate) {
        return saleDetailRepository.findByProduct(soldDate);
    }

}
