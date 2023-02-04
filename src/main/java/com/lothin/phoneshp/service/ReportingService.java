package com.lothin.phoneshp.service;

import java.util.List;
import java.time.LocalDate;
import com.lothin.phoneshp.projections.SaleByDate;

public interface ReportingService {
    List<SaleByDate> getProductSoldByDate(LocalDate SoldDate);
}
