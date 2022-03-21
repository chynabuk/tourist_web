package org.example.services.Impl;

import org.example.dao.extd.HotelNumberDao;
import org.example.entities.HotelNumber;
import org.example.services.HotelNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelNumberServiceImpl implements HotelNumberService {
    @Autowired
    private HotelNumberDao hotelNumberDao;

    @Override
    public void delete(Integer id) {
        hotelNumberDao.delete(id);
    }

    @Override
    public void insert(HotelNumber hotelNumber) {
        hotelNumberDao.insert(hotelNumber);
    }

    @Override
    public HotelNumber getBy(Integer id) {
        return hotelNumberDao.getBy(id);
    }

    @Override
    public List<HotelNumber> getAll() {
        return hotelNumberDao.getAll();
    }

    @Override
    public void update(HotelNumber hotelNumber) {
        hotelNumberDao.update(hotelNumber);
    }
}
