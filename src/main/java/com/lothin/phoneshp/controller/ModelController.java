package com.lothin.phoneshp.controller;

// import java.util.List;
import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.BeanUtils;
// import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
// import org.mapstruct.Mapper;
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
import com.lothin.phoneshp.mapper.ModelMapper;
import com.lothin.phoneshp.mapper.PageMapper;
import com.lothin.phoneshp.model.Model;
import com.lothin.phoneshp.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {

    private final ModelService modelService;
    
    private final ModelMapper modelMapper;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ModelDTO dto) throws ApiException {
        Model model = modelMapper.toModel(dto);
        model = modelService.save(model);
        ModelDTO modelDTO = ModelMapper.INSTANCE.toDTO(model);
        return ResponseEntity.ok(modelDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) throws ApiException {
        Model model = modelService.getById(id);
        return ResponseEntity.ok(ModelMapper.INSTANCE.toDTO(model));
    }

    @GetMapping
    public ResponseEntity<?> getAllModels(@RequestParam Map<String, String> params) {
        // List<ModelDTO> list = modelService.getAllModels(params)
        // .stream()
        // .map(m -> ModelMapper.INSTANCE.toDTO(m))
        // .toList();
        // return ResponseEntity.ok(list);
        Page<Model> page = modelService.getAllModels(params);
        // Page<ModelDTO> page2 = Page.empty();
        // BeanUtils.copyProperties(page, page2);
        // PageDTO pageDTO = new PageDTO(page);
        PageDTO dto = PageMapper.INSTANCE.toDTO(page);
        // dto.setList(page.get().map(m -> ModelMapper.INSTANCE.toDTO(m)).toList());
        dto.setList(page.get().map(ModelMapper.INSTANCE::toDTO).toList());

        return ResponseEntity.ok(dto);
    }

}
