package org.example.dao.extd.impl;

import org.example.dao.extd.EventDao;
import org.example.entities.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer eventId) {
        Session session = sessionFactory.getCurrentSession();
        Event event = getBy(eventId);
        session.delete(event);
    }

    @Override
    public void insert(Event event) {
        Session session = sessionFactory.getCurrentSession();
        session.save(event);
    }

    @Override
    public Event getBy(Integer eventId) {
        Session session = sessionFactory.getCurrentSession();
        Event event = session.get(Event.class, eventId);
        return event;
    }

    @Override
    public List<Event> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Event> events = session.createQuery("from Event").getResultList();
        return events;
    }

    @Override
    public void update(Event event) {
        Session session = sessionFactory.getCurrentSession();
        session.update(event);
    }
}
