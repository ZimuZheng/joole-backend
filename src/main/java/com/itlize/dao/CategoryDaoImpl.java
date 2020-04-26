package com.itlize.dao;

import com.itlize.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CategoryDaoImpl implements CategoryDao{

    @Autowired
    private SessionFactory sessionFactory;


    // Create
    @Override
    public void addCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
//        // session.close();
        return;
    }

    @Override
    public List<Category> getAllCategory() {
        Session session = sessionFactory.getCurrentSession();
        List<Category> categories = session.createQuery("from Category").list();
//        // session.close();
        return categories;
    }

    //   Session session = sf.getCurrentSession();
    //   session.load(Category.class, Long (1));
    //   // session.close();




    // Read
    @Override
    public List<Category> getCategoryByCname(String cname) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder sql = new StringBuilder("from Category c where c.cname = \'");
        sql.append(cname);
        sql.append("\'");
        List<Category> categoryList = session.createQuery(sql.toString()).list();
//        // session.close();
        return categoryList;
    }

    @Override
    public Category getCategoryBySubcname(String sub_cname) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder sql = new StringBuilder("from Category c where c.sub_cname = \'");
        sql.append(sub_cname);
        sql.append("\'");
        List<Category> categoryList = session.createQuery(sql.toString()).list();
//        // session.close();
        if (categoryList.size() == 0) {
            return null;
        }
        return categoryList.get(0);

    }


    // Update
    @Override
    public void updateCategory(Category category) {

    }


    // Delete
    @Override
    public void deleteCategory(Category category) {

    }

}