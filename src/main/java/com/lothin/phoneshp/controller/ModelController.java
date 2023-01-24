package com.lothin.phoneshp.controller;

import org.mapstruct.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lothin.phoneshp.dto.ModelDTO;
import com.lothin.phoneshp.exception.ApiException;
import com.lothin.phoneshp.mapper.ModelMapper;
import com.lothin.phoneshp.model.Model;
import com.lothin.phoneshp.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {

    private final ModelService modelService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ModelDTO dto) throws ApiException {
        Model model = modelService.save(dto);
        ModelDTO modelDTO = ModelMapper.INSTANCE.toDTO(model);
        return ResponseEntity.ok(modelDTO);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) throws ApiException {
        Model model = modelService.getById(id);
        return ResponseEntity.ok(ModelMapper.INSTANCE.toDTO(model));
    }

}
