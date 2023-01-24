package com.lothin.phoneshp.service;

import org.springframework.stereotype.Service;

import com.lothin.phoneshp.dto.ModelDTO;
import com.lothin.phoneshp.model.Model;
@Service
public interface ModelService {
    Model save(ModelDTO dto);
    Model getById(Integer id);
}
