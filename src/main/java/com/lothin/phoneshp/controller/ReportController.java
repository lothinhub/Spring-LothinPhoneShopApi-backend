package com.lothin.phoneshp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.lothin.phoneshp.service.ReportingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.lothin.phoneshp.projections.SaleByDate;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportController {
    private final ReportingService reportingService;

    public ResponseEntity<?> getProductSaleByDate(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate soldDate) {
        List<SaleByDate> productSaleByDate = reportingService.getProductSoldByDate(soldDate);
        return ResponseEntity.ok(productSaleByDate);
    }
}
