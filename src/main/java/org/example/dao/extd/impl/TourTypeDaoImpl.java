package org.example.dao.extd.impl;

import org.example.dao.extd.TourTypeDao;
import org.example.entities.TourType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourTypeDaoImpl implements TourTypeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer tourTypeId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getBy(tourTypeId));
    }

    @Override
    public void insert(TourType tourType) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tourType);
    }

    @Override
    public TourType getBy(Integer tourTypeId) {
        Session session = sessionFactory.getCurrentSession();
        TourType tourType = session.get(TourType.class, tourTypeId);
        return tourType;
    }

    @Override
    public List<TourType> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<TourType> tourTypes = session.createQuery("from TourType").getResultList();
        return tourTypes;
    }
}
