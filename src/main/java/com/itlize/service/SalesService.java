package com.itlize.service;

import com.itlize.entity.Sales;

import java.util.List;

public interface SalesService {

    // C
    void addNewSales(Sales sales) throws Exception;

    // R
    Sales getSalesById(Long sid) throws Exception;

    // U
    void updateSales(Sales sales);

    // D
    void deleteSales(Sales sales);
}
