package com.itlize.service;

import com.itlize.entity.Attribute;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AttributeService {

    // C
    void addNewAttribute(Attribute attribute) throws Exception;

    // R
    List<Attribute> getAllAttribute();

    Attribute getAttributeById(Long aid) throws Exception;

    // U
    void updateAttribute(Attribute attribute);

    // D
    void deleteAttribute(Attribute attribute);
}
