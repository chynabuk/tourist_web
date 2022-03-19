package org.example.dao.extd.impl;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.dao.extd.TouristDao;
import org.example.entities.Tourist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TouristDaoImpl implements TouristDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer passportNumber) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getBy(passportNumber));
    }

    @Override
    public void insert(Tourist tourist) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tourist);
    }

    @Override
    public Tourist getBy(Integer passportNumber) {
        Session session = sessionFactory.getCurrentSession();
        Tourist tourist = session.get(Tourist.class, passportNumber);
        return tourist;
    }

    @Override
    public List getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Tourist> tourists = session.createQuery("from Tourist").getResultList();
        return tourists;
    }

    @Override
    public void update(Tourist tourist) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tourist);
    }
}
