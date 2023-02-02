package com.lothin.phoneshp.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lothin.phoneshp.exception.ResourceNotFoundException;
import com.lothin.phoneshp.model.Color;
import com.lothin.phoneshp.repository.ColorRepository;
import com.lothin.phoneshp.service.ColorService;
// import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
@Service
// @Slf4j
@RequiredArgsConstructor
public class ColorServiceImple implements ColorService {
    @Autowired
    private final ColorRepository colorRepository;

    @Override 
    public Color save(Color entity) {
        return colorRepository.save(entity);
    }

    @Override
    public Color getById(Long id) {
        return colorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Color", id));

    }

}
