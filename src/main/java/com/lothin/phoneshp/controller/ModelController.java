package com.lothin.phoneshp.controller;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lothin.phoneshp.dto.ModelDTO;
import com.lothin.phoneshp.dto.PageDTO;
import com.lothin.phoneshp.exception.ApiException;
import com.lothin.phoneshp.mapper.ModelEntityMapper;
import com.lothin.phoneshp.mapper.PageMapper;
import com.lothin.phoneshp.model.Model;
import com.lothin.phoneshp.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
	
	private final ModelService modelService;
	
	private final ModelEntityMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO dto) throws ApiException{
		Model model = modelMapper.toModel(dto);
		model = modelService.save(model);
		ModelDTO modelDTO = ModelEntityMapper.INSTANCE.toDTO(model);
		return ResponseEntity.ok(modelDTO);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) throws ApiException{
		Model model = modelService.getById(id);
		return ResponseEntity.ok(ModelEntityMapper.INSTANCE.toDTO(model));
	}
	
	@GetMapping
	public ResponseEntity<?> getModelList(@RequestParam Map<String, String> params){
		Page<Model> page = modelService.getModels(params);
		
		PageDTO dto = PageMapper.INSTANCE.toDTO(page);
		dto.setList(page.get().map(ModelEntityMapper.INSTANCE::toDTO).toList());
		return ResponseEntity.ok(dto);
	}

}
