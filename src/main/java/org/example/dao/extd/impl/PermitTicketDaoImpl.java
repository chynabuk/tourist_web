package org.example.dao.extd.impl;

import org.example.dao.extd.PermitTicketDao;
import org.example.entities.PermitTicket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PermitTicketDaoImpl implements PermitTicketDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        PermitTicket permitTicket = getBy(id);
        session.delete(permitTicket);
    }

    @Override
    public void insert(PermitTicket permitTicket) {
        Session session = sessionFactory.getCurrentSession();
        session.save(permitTicket);
    }

    @Override
    public PermitTicket getBy(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        PermitTicket permitTicket = session.get(PermitTicket.class, id);
        return permitTicket;
    }

    @Override
    public List<PermitTicket> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<PermitTicket> permitTickets = session.createQuery("from PermitTicket ").getResultList();
        return permitTickets;
    }

    @Override
    public void update(PermitTicket permitTicket) {
        Session session = sessionFactory.getCurrentSession();
        session.update(permitTicket);
    }
}
