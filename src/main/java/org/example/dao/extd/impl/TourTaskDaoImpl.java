package org.example.dao.extd.impl;

import org.example.dao.extd.TourTaskDao;
import org.example.entities.TourTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourTaskDaoImpl implements TourTaskDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer taskNumber) {
        Session session = sessionFactory.getCurrentSession();
        TourTask tourTask = getBy(taskNumber);
        session.delete(tourTask);
    }

    @Override
    public void insert(TourTask tourTask) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tourTask);
    }

    @Override
    public TourTask getBy(Integer taskNumber) {
        Session session = sessionFactory.getCurrentSession();
        TourTask tourTask = session.get(TourTask.class, taskNumber);
        return tourTask;
    }

    @Override
    public List<TourTask> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<TourTask> tourTasks = session.createQuery("from TourTask").getResultList();
        return tourTasks;
    }

    @Override
    public void update(TourTask tourTask) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tourTask);
    }
}
