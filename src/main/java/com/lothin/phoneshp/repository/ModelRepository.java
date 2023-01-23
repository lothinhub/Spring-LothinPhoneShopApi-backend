package com.lothin.phoneshp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lothin.phoneshp.model.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}
