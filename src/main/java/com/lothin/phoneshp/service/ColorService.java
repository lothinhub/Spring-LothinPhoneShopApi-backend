package com.lothin.phoneshp.service;

import com.lothin.phoneshp.model.Color;

public interface ColorService {

    Color save(Color entity);

    Color getById(Long id);
}
