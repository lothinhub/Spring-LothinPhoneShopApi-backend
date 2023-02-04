package com.lothin.phoneshp.projections;

import java.time.LocalDate;

public interface SaleByDate {

    LocalDate getSoldDate();

    Long getProductId();

    String getProductName();

    Long getTotalUnit();

    Double getAmount();
}
