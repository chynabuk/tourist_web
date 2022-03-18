package org.example.dao.extd.impl;

import org.example.dao.extd.PositionDao;
import org.example.entities.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PositionDaoImpl implements PositionDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insert(Position position) {
        Session session = sessionFactory.getCurrentSession();
        session.save(position);
    }

    @Override
    public Position getBy(Integer positionId) {
        Session session = sessionFactory.getCurrentSession();
        Position position = session.get(Position.class, positionId);
        return position;
    }

    @Override
    public List getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Position> positions = session.createQuery("from Position").getResultList();
        return positions;
    }
}
