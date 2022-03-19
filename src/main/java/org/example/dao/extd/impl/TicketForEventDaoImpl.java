package org.example.dao.extd.impl;

import org.example.dao.extd.TicketForEventDao;
import org.example.entities.TicketForEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketForEventDaoImpl implements TicketForEventDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer ticketNumber) {
        Session session = sessionFactory.getCurrentSession();
        TicketForEvent ticketForEvent = getBy(ticketNumber);
        session.delete(ticketForEvent);
    }

    @Override
    public void insert(TicketForEvent ticketForEvent) {
        Session session = sessionFactory.getCurrentSession();
        session.save(ticketForEvent);
    }

    @Override
    public TicketForEvent getBy(Integer ticketNumber) {
        Session session = sessionFactory.getCurrentSession();
        TicketForEvent ticketForEvent = session.get(TicketForEvent.class, ticketNumber);
        return ticketForEvent;
    }

    @Override
    public List<TicketForEvent> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<TicketForEvent> ticketForEvents = session.createQuery("from TicketForEvent").getResultList();
        return ticketForEvents;
    }

    @Override
    public void update(TicketForEvent ticketForEvent) {
        Session session = sessionFactory.getCurrentSession();
        session.update(ticketForEvent);
    }
}
