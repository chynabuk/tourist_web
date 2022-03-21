package org.example.services.Impl;

import org.example.dao.extd.TourTaskDao;
import org.example.entities.TourTask;
import org.example.services.TourTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TourTaskServiceImpl implements TourTaskService {
    @Autowired
    private TourTaskDao tourTaskDao;

    @Override
    public void delete(Integer taskNumber) {
        tourTaskDao.delete(taskNumber);
    }

    @Override
    public void insert(TourTask tourTask) {
        tourTaskDao.insert(tourTask);
    }

    @Override
    public TourTask getBy(Integer taskNumber) {
        return tourTaskDao.getBy(taskNumber);
    }

    @Override
    public List<TourTask> getAll() {
        return tourTaskDao.getAll();
    }

    @Override
    public void update(TourTask tourTask) {
        tourTaskDao.update(tourTask);
    }
}
