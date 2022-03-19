package org.example.dao.extd.impl;

import org.example.dao.extd.AviaClassDao;
import org.example.entities.AviaClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AviaClassDaoImpl implements AviaClassDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void insert(AviaClass aviaClass) {
        Session session = sessionFactory.getCurrentSession();
        session.save(aviaClass);
    }

    @Override
    public AviaClass getBy(Integer aviaClassId) {
        Session session = sessionFactory.getCurrentSession();
        AviaClass aviaClass = session.get(AviaClass.class, aviaClassId);
        return aviaClass;
    }

    @Override
    public List<AviaClass> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<AviaClass> aviaClasses = session.createQuery("from AviaClass").getResultList();
        return aviaClasses;
    }
}
