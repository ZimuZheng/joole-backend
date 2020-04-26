package com.itlize.dao;

import com.itlize.entity.Attribute;

import java.util.List;

public interface AttributeDao {

    // C
    void addAttribute(Attribute attribute);

    // R
    List<Attribute> getAllAttribute();

    Attribute getAttributeById(Long aid);

    // U
    void updateAttribute(Attribute attribute);

    // D
    void deleteAttribute(Attribute attribute);
}
