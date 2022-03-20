package org.example.dao.extd.impl;

import org.example.dao.extd.HotelDao;
import org.example.entities.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelDaoImpl implements HotelDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Hotel hotel = getBy(id);
        session.delete(hotel);
    }

    @Override
    public void insert(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.save(hotel);
    }

    @Override
    public Hotel getBy(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Hotel hotel = session.get(Hotel.class, id);
        return hotel;
    }

    @Override
    public List<Hotel> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Hotel> hotels = session.createQuery("from Hotel ").getResultList();
        return hotels;
    }

    @Override
    public void update(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.update(hotel);
    }
}
