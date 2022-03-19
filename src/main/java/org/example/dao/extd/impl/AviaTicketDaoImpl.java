package org.example.dao.extd.impl;

import org.example.dao.extd.AviaTicketDao;
import org.example.entities.AviaTicket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AviaTicketDaoImpl implements AviaTicketDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        AviaTicket aviaTicket = getBy(id);
        session.delete(aviaTicket);
    }

    @Override
    public void insert(AviaTicket aviaTicket) {
        Session session = sessionFactory.getCurrentSession();
        session.save(aviaTicket);
    }

    @Override
    public AviaTicket getBy(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        AviaTicket aviaTicket = session.get(AviaTicket.class, id);
        return aviaTicket;
    }

    @Override
    public List<AviaTicket> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<AviaTicket> aviaTickets = session.createQuery("from AviaTicket").getResultList();
        return aviaTickets;
    }

    @Override
    public void update(AviaTicket aviaTicket) {
        Session session = sessionFactory.getCurrentSession();
        session.update(aviaTicket);
    }
}
