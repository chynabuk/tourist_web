package org.example.dao.extd.impl;

import org.example.dao.extd.PermitDao;
import org.example.entities.Permit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PermitDaoImpl implements PermitDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Permit permit = getBy(id);
        session.delete(permit);
    }

    @Override
    public void insert(Permit permit) {
        Session session = sessionFactory.getCurrentSession();
        session.save(permit);
    }

    @Override
    public Permit getBy(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Permit permit = session.get(Permit.class, id);
        return permit;
    }

    @Override
    public List<Permit> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Permit> permits = session.createQuery("from Permit ").getResultList();
        return permits;
    }

    @Override
    public void update(Permit permit) {
        Session session = sessionFactory.getCurrentSession();
        session.update(permit);
    }
}
