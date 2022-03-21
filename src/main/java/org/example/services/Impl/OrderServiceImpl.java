package org.example.services.Impl;

import org.example.dao.extd.OrderDao;
import org.example.entities.Order;
import org.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public void delete(Integer orderNumber) {
        orderDao.delete(orderNumber);
    }

    @Override
    public void insert(Order order) {
        orderDao.insert(order);
    }

    @Override
    public Order getBy(Integer orderNumber) {
        return orderDao.getBy(orderNumber);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public void update(Order order) {
        orderDao.update(order);
    }
}
