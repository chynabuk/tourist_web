package org.example.dao.extd.impl;

import org.example.dao.extd.HotelClassDao;
import org.example.entities.HotelClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HotelClassDaoImpl implements HotelClassDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insert(HotelClass hotelClass) {
        Session session = sessionFactory.getCurrentSession();
        session.save(hotelClass);
    }

    @Override
    public HotelClass getBy(Integer hotelClassId) {
        Session session = sessionFactory.getCurrentSession();
        HotelClass hotelClass = session.get(HotelClass.class, hotelClassId);
        return hotelClass;
    }

    @Override
    public List getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<HotelClass> hotelClasses = session.createQuery("from HotelClass ").getResultList();
        return hotelClasses;
    }
}
