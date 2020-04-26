package com.itlize.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.itlize.entity.User;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.openSession();
        session.save(user);
        session.close();
        return ;
    }

    @Override
    public User findUserByUsername(String username) {
        Session session = this.sessionFactory.openSession();
        List<User> users = session.createQuery("from User").list();
        for (int i=0; i<users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return users.get(i);
            }
        }
        session.close();
        return null;
    }

}
