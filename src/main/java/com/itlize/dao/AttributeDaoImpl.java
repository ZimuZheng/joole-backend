package com.itlize.dao;

import com.itlize.entity.Attribute;
import com.itlize.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttributeDaoImpl implements AttributeDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addAttribute(Attribute attribute) {
        Session session = sessionFactory.getCurrentSession();
        session.save(attribute);
//        // session.close();
    }

    @Override
    public List<Attribute> getAllAttribute() {
        Session session = sessionFactory.getCurrentSession();
        List<Attribute> attributes = session.createQuery("from Attribute").list();
        return attributes;
    }

    @Override
    public Attribute getAttributeById(Long aid) {
        Session session = sessionFactory.getCurrentSession();
        Attribute attribute = (Attribute) session.load(Attribute.class, aid);
        return attribute;
    }

    @Override
    public void updateAttribute(Attribute attribute) {
    }

    @Override
    public void deleteAttribute(Attribute attribute) {
    }
}
