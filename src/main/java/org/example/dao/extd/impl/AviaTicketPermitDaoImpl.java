package org.example.dao.extd.impl;

import org.example.dao.extd.AviaTicketPermitDao;
import org.example.entities.AviaTicketPermit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AviaTicketPermitDaoImpl implements AviaTicketPermitDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        AviaTicketPermit aviaTicketPermit = getBy(id);
        session.delete(aviaTicketPermit);
    }

    @Override
    public void insert(AviaTicketPermit aviaTicketPermit) {
        Session session = sessionFactory.getCurrentSession();
        session.save(aviaTicketPermit);
    }

    @Override
    public AviaTicketPermit getBy(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        AviaTicketPermit aviaTicketPermit = session.get(AviaTicketPermit.class, id);
        return aviaTicketPermit;
    }

    @Override
    public List<AviaTicketPermit> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<AviaTicketPermit> aviaTicketPermits = session.createQuery("from AviaTicketPermit ").getResultList();
        return aviaTicketPermits;
    }

    @Override
    public void update(AviaTicketPermit aviaTicketPermit) {
        Session session = sessionFactory.getCurrentSession();
        session.update(aviaTicketPermit);
    }
}
