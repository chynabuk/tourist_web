package org.example.services;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.Order;

public interface OrderService extends Insertion<Order>, Deletion, Update<Order>, Select<Order> {
}
