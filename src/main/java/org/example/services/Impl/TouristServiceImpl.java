package org.example.services.Impl;

import org.example.dao.extd.TouristDao;
import org.example.entities.Tourist;
import org.example.services.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TouristServiceImpl implements TouristService {
    @Autowired
    private TouristDao touristDao;

    @Override
    public void insert(Tourist tourist) {
        touristDao.insert(tourist);
    }

    @Override
    public void update(Tourist tourist) {
        touristDao.update(tourist);
    }

    @Override
    public void delete(Integer passportNumber) {
        touristDao.delete(passportNumber);
    }

    @Override
    public Tourist getBy(Integer passportNumber) {
        return touristDao.getBy(passportNumber);
    }

    @Override
    public List getAll() {
        return touristDao.getAll();
    }
}
