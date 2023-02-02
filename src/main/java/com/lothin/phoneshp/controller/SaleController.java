package com.lothin.phoneshp.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lothin.phoneshp.dto.SaleDTO;
import com.lothin.phoneshp.service.SellService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/sells")
@RequiredArgsConstructor
public class SaleController {

    private final SellService sellService;

    @PostMapping
    public ResponseEntity<?> sell(@RequestBody SaleDTO dto) {
        sellService.sell(dto);
        return ResponseEntity.ok().build();
    }
}
