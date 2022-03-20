package org.example.dao.extd.impl;

import org.example.dao.extd.HotelNumberCategoryDao;
import org.example.entities.HotelNumberCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelNumberCategoryImpl implements HotelNumberCategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(HotelNumberCategory hotelNumberCategory) {
        Session session = sessionFactory.getCurrentSession();
        session.save(hotelNumberCategory);
    }

    @Override
    public HotelNumberCategory getBy(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        HotelNumberCategory hotelNumberCategory = session.get(HotelNumberCategory.class, id);
        return hotelNumberCategory;
    }

    @Override
    public List<HotelNumberCategory> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<HotelNumberCategory> hotelNumberCategories = session.createQuery("from HotelNumberCategory ").getResultList();
        return hotelNumberCategories;
    }
}
