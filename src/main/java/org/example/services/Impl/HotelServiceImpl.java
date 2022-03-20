package org.example.services.Impl;

import org.example.dao.extd.HotelDao;
import org.example.entities.Hotel;
import org.example.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDao hotelDao;

    @Override
    public void delete(Integer id) {
        hotelDao.delete(id);
    }

    @Override
    public void insert(Hotel hotel) {
        hotelDao.insert(hotel);
    }

    @Override
    public Hotel getBy(Integer id) {
        return hotelDao.getBy(id);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelDao.getAll();
    }

    @Override
    public void update(Hotel hotel) {
        hotelDao.update(hotel);
    }
}
