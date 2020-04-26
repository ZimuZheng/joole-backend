package com.itlize.dao;

import com.itlize.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addNewProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
        // session.close();
    }

    @Override
    public List<Product> getAllProduct() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product").list();
        // session.close();
        return products;
    }

    @Override
    public List<Product> getAllProductWithCategory(Long cid) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder sql = new StringBuilder("from Product p where p.categoryEntity = \'");
        sql.append(cid);
        sql.append("\'");
        List<Product> products = session.createQuery(sql.toString()).list();
        // session.close();
        return products;
    }

    @Override
    public Product getProductById(Long pid) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder sql = new StringBuilder("from Product p where p.pid = \'");
        sql.append(pid);
        sql.append("\'");
        List<Product> products = session.createQuery(sql.toString()).list();
        // session.close();
        return products.get(0);
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(Product product) {

    }
}
