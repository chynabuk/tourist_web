package org.example.dao.extd.impl;

import org.example.dao.extd.AgreementDao;
import org.example.entities.Agreement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgreementDaoImpl implements AgreementDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Agreement agreement = getBy(id);
        session.delete(agreement);
    }

    @Override
    public void insert(Agreement agreement) {
        Session session = sessionFactory.getCurrentSession();
        session.save(agreement);
    }

    @Override
    public Agreement getBy(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Agreement agreement = session.get(Agreement.class, id);
        return agreement;
    }

    @Override
    public List<Agreement> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Agreement> agreements = session.createQuery("from Agreement ").getResultList();
        return agreements;
    }

    @Override
    public void update(Agreement agreement) {
        Session session = sessionFactory.getCurrentSession();
        session.update(agreement);
    }
}
