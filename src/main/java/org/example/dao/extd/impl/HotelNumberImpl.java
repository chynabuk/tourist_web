package org.example.dao.extd.impl;

import org.example.dao.extd.HotelNumberDao;
import org.example.entities.HotelNumber;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelNumberImpl implements HotelNumberDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        HotelNumber hotelNumber = getBy(id);
        session.delete(hotelNumber);
    }

    @Override
    public void insert(HotelNumber hotelNumber) {
        Session session = sessionFactory.getCurrentSession();
        session.save(hotelNumber);
    }

    @Override
    public HotelNumber getBy(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        HotelNumber hotelNumber = session.get(HotelNumber.class, id);
        return hotelNumber;
    }

    @Override
    public List<HotelNumber> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<HotelNumber> hotelNumbers = session.createQuery("from HotelNumber ").getResultList();
        return hotelNumbers;
    }

    @Override
    public void update(HotelNumber hotelNumber) {
        Session session = sessionFactory.getCurrentSession();
        session.update(hotelNumber);
    }
}
