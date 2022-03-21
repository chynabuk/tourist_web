package org.example.dao.extd.impl;

import org.example.dao.extd.HotelNumberPermitDao;
import org.example.entities.HotelNumberPermit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelNumberPermitDaoImpl implements HotelNumberPermitDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        HotelNumberPermit hotelNumberPermit = getBy(id);
        session.delete(hotelNumberPermit);
    }

    @Override
    public void insert(HotelNumberPermit hotelNumberPermit) {
        Session session = sessionFactory.getCurrentSession();
        session.save(hotelNumberPermit);
    }

    @Override
    public HotelNumberPermit getBy(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        HotelNumberPermit hotelNumberPermit = session.get(HotelNumberPermit.class, id);
        return hotelNumberPermit;
    }

    @Override
    public List<HotelNumberPermit> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<HotelNumberPermit> hotelNumberPermits = session.createQuery("from HotelNumberPermit ").getResultList();
        return hotelNumberPermits;
    }

    @Override
    public void update(HotelNumberPermit hotelNumberPermit) {
        Session session = sessionFactory.getCurrentSession();
        session.update(hotelNumberPermit);
    }
}
