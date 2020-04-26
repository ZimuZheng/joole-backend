package com.itlize.dao;

import com.itlize.entity.Manufacturer;
import com.itlize.entity.Sales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ManufacturerDaoImpl implements ManufacturerDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addManufacturer(Manufacturer manufacturer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(manufacturer);
        // session.close();
        return;
    }

    @Override
    public Manufacturer getManufacturerById(Long mid) {
        Session session = sessionFactory.getCurrentSession();
        Manufacturer manufacturer = (Manufacturer) session.load(Manufacturer.class, mid);
        return manufacturer;
    }

    @Override
    public void updateManufacturer(Manufacturer manufacturer) {

    }

    @Override
    public void deleteManufacturer(Manufacturer manufacturer) {

    }
}
