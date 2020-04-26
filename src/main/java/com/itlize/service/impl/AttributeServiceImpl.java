package com.itlize.service.impl;

import com.itlize.dao.AttributeDao;
import com.itlize.entity.Attribute;
import com.itlize.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeDao attributeDao;

    @Override
    @Transactional
    public void addNewAttribute(Attribute attribute) throws Exception{
        try {
            if (attribute == null) {
                return ;
            }
            attributeDao.addAttribute(attribute);
            return ;
        } catch (DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("The information provided cannot be accepted", e);
        } catch (Exception e) {
            throw new Exception("Unknown error", e);
        }
    }

    @Override
    @Transactional
    public List<Attribute> getAllAttribute() {
            return attributeDao.getAllAttribute();
    }

    @Override
    @Transactional
    public Attribute getAttributeById(Long aid) throws Exception {
        try {
            return attributeDao.getAttributeById(aid);
        } catch (DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("The information provided cannot be accepted", e);
        } catch (Exception e) {
            throw new Exception("Unknown error", e);
        }
    }

    @Override
    @Transactional
    public void updateAttribute(Attribute attribute) {
        attributeDao.updateAttribute(attribute);
        return ;
    }

    @Override
    @Transactional
    public void deleteAttribute(Attribute attribute) {
        attributeDao.deleteAttribute(attribute);
        return ;
    }
}
