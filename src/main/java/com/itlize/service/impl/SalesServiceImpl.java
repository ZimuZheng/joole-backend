package com.itlize.service.impl;

import com.itlize.dao.SalesDao;
import com.itlize.entity.Sales;
import com.itlize.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;

public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesDao salesDao;

    @Override
    @Transactional
    public void addNewSales(Sales sales) throws Exception {
        try {
            salesDao.addSales(sales);
            return;
        } catch (DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("The information provided cannot be accepted", e);
        } catch (Exception e) {
            throw new Exception("Unknown error", e);
        }

    }

    @Override
    @Transactional
    public Sales getSalesById(Long sid) throws Exception {
        try {
            return salesDao.getSalesById(sid);
        } catch (DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("The information provided cannot be accepted", e);
        } catch (Exception e) {
            throw new Exception("Unknown error", e);
        }
    }

    @Override
    @Transactional
    public void updateSales(Sales sales) {

    }

    @Override
    @Transactional
    public void deleteSales(Sales sales) {

    }
}
