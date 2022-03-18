package org.example.dao.extd.impl;

import org.example.dao.extd.TourDao;
import org.example.entities.Tour;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourDaoImpl implements TourDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer tourNumber) {
        Session session = sessionFactory.getCurrentSession();
        Tour tour = getBy(tourNumber);
        session.delete(tour);
    }

    @Override
    public void insert(Tour tour) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tour);
    }

    @Override
    public Tour getBy(Integer tourNumber) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Tour.class, tourNumber);
    }

    @Override
    public List<Tour> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Tour> tours = session.createQuery("from Tour").getResultList();
        return tours;
    }

    @Override
    public void update(Tour tour) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tour);
    }
}
