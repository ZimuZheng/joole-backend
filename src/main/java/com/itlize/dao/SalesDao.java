package com.itlize.dao;

import com.itlize.entity.Sales;

import java.util.List;

public interface SalesDao {

    // C
    void addSales(Sales sales);

    // R
    Sales getSalesById(Long sid);

    // U
    void updateSales(Sales sales);

    // D
    void deleteSales(Sales sales);
}
