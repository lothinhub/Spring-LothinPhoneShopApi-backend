package com.lothin.phoneshp.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.lothin.phoneshp.model.Model;

@Service
public interface ModelService {
    Model save(Model dto);

    Model getById(Long id);

    Page<Model> getAllModels(Map<String, String> params);
}
