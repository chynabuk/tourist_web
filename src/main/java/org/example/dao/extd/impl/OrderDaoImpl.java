package org.example.dao.extd.impl;

import org.example.dao.extd.OrderDao;
import org.example.entities.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer orderNumber) {
        Session session = sessionFactory.getCurrentSession();
        Order order = getBy(orderNumber);
        session.delete(order);
    }

    @Override
    public void insert(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
    }

    @Override
    public Order getBy(Integer orderNumber) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, orderNumber);
        return order;
    }

    @Override
    public List<Order> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Order> orders = session.createQuery("from Order").getResultList();
        return orders;
    }

    @Override
    public void update(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
    }
}
