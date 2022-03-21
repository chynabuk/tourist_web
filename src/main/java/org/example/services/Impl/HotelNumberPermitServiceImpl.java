package org.example.services.Impl;

import org.example.dao.extd.HotelNumberPermitDao;
import org.example.entities.HotelNumberPermit;
import org.example.services.HotelNumberPermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelNumberPermitServiceImpl implements HotelNumberPermitService {
    @Autowired
    private HotelNumberPermitDao hotelNumberPermitDao;

    @Override
    public void delete(Integer id) {
        hotelNumberPermitDao.delete(id);
    }

    @Override
    public void insert(HotelNumberPermit hotelNumberPermit) {
        hotelNumberPermitDao.insert(hotelNumberPermit);
    }

    @Override
    public HotelNumberPermit getBy(Integer id) {
        return hotelNumberPermitDao.getBy(id);
    }

    @Override
    public List<HotelNumberPermit> getAll() {
        return hotelNumberPermitDao.getAll();
    }

    @Override
    public void update(HotelNumberPermit hotelNumberPermit) {
        hotelNumberPermitDao.update(hotelNumberPermit);
    }
}
