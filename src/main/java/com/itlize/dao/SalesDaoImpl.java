package com.itlize.dao;

import com.itlize.entity.Sales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SalesDaoImpl implements SalesDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSales(Sales sales) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sales);
        // session.close();
        return;
    }

    @Override
    public Sales getSalesById(Long sid) {
        Session session = sessionFactory.getCurrentSession();
        Sales sales = (Sales) session.load(Sales.class, sid);
        return sales;
    }

    @Override
    public void updateSales(Sales sales) {

    }

    @Override
    public void deleteSales(Sales sales) {

    }
}
