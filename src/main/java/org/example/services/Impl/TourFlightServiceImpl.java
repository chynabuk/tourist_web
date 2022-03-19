package org.example.services.Impl;

import org.example.dao.extd.TourFlightDao;
import org.example.entities.TourFlight;
import org.example.services.TourFlightSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TourFlightServiceImpl implements TourFlightSevice {
    @Autowired
    private TourFlightDao tourFlightDao;

    @Override
    public void delete(Integer flightCode) {
        tourFlightDao.delete(flightCode);
    }

    @Override
    public void insert(TourFlight tourFlight) {
        tourFlightDao.insert(tourFlight);
    }

    @Override
    public TourFlight getBy(Integer flightCode) {
        return tourFlightDao.getBy(flightCode);
    }

    @Override
    public List<TourFlight> getAll() {
        return tourFlightDao.getAll();
    }

    @Override
    public void update(TourFlight tourFlight) {
        tourFlightDao.update(tourFlight);
    }
}