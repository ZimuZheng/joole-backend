package com.itlize.service.impl;

import com.itlize.dao.ManufacturerDao;
import com.itlize.entity.Manufacturer;
import com.itlize.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerDao manufacturerDao;

    @Override
    public void addNewManufacturer(Manufacturer manufacturer) throws Exception {
        try {
            manufacturerDao.addManufacturer(manufacturer);
            return;
        } catch (DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("The information provided cannot be accepted", e);
        } catch (Exception e) {
            throw new Exception("Unknown error", e);
        }
    }

    @Override
    public Manufacturer getManufacturerById(Long mid) throws Exception {
        try {
            return manufacturerDao.getManufacturerById(mid);
        } catch (DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("The information provided cannot be accepted", e);
        } catch (Exception e) {
            throw new Exception("Unknown error", e);
        }
    }

    @Override
    public void updateManufacturer(Manufacturer manufacturer) {

    }

    @Override
    public void deleteManufacturer(Manufacturer manufacturer) {

    }
}
