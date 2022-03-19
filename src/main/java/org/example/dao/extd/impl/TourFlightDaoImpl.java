package org.example.dao.extd.impl;

import org.example.dao.extd.TourFlightDao;
import org.example.entities.TourFlight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourFlightDaoImpl implements TourFlightDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer flightCode) {
        Session session = sessionFactory.getCurrentSession();
        TourFlight tourFlight = getBy(flightCode);
        session.delete(tourFlight);
    }

    @Override
    public void insert(TourFlight tourFlight) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tourFlight);
    }

    @Override
    public TourFlight getBy(Integer flightCode) {
        Session session = sessionFactory.getCurrentSession();
        TourFlight tourFlight = session.get(TourFlight.class, flightCode);
        return tourFlight;
    }

    @Override
    public List<TourFlight> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<TourFlight> tourFlights = session.createQuery("from TourFlight").getResultList();
        return tourFlights;
    }

    @Override
    public void update(TourFlight tourFlight) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tourFlight);
    }
}
