package com.lothin.phoneshp.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lothin.phoneshp.dto.ModelDTO;
import com.lothin.phoneshp.model.Model;
@Service
public interface ModelService {
    Model save(ModelDTO dto);
    Model getById(Integer id);
    List<Model> getAllModels(Map<String,String> params);

}
