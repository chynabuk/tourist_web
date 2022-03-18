package org.example.dao.extd.impl;

import org.example.dao.extd.CountryDao;
import org.example.entities.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer countryId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getBy(countryId));
    }

    @Override
    public void insert(Country country) {
        Session session = sessionFactory.getCurrentSession();
        session.save(country);
    }

    @Override
    public Country getBy(Integer countryId) {
        Session session = sessionFactory.getCurrentSession();
        Country country = session.get(Country.class, countryId);
        return country;
    }

    @Override
    public List<Country> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Country").getResultList();
    }
}
