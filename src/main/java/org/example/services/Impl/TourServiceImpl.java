package org.example.services.Impl;

import org.example.dao.extd.TourDao;
import org.example.entities.Tour;
import org.example.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TourServiceImpl implements TourService {
    @Autowired
    private TourDao tourDao;

    @Override
    public void delete(Integer tourNumber) {
        tourDao.delete(tourNumber);
    }

    @Override
    public void insert(Tour tour) {
        tourDao.insert(tour);
    }

    @Override
    public Tour getBy(Integer tourNumber) {
        return tourDao.getBy(tourNumber);
    }

    @Override
    public List<Tour> getAll() {
        return tourDao.getAll();
    }

    @Override
    public void update(Tour tour) {
        tourDao.update(tour);
    }
}
