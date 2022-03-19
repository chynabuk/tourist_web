package org.example.services.Impl;

import org.example.dao.extd.HotelClassDao;
import org.example.entities.HotelClass;
import org.example.enums.HotelClassEnum;
import org.example.services.HotelClassService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelClassServiceImpl implements HotelClassService {
    @Autowired
    private HotelClassDao hotelClassDao;

    @Override
    public void insert(HotelClass hotelClass) {
        hotelClassDao.insert(hotelClass);
    }

    @Override
    public void addAll() {
        if (!hotelClassDao.getAll().isEmpty()){
            for (HotelClassEnum hotelClassEnum : HotelClassEnum.values()){
                HotelClass hotelClass = new HotelClass();
                hotelClass.setHotelClassEnum(hotelClassEnum);
                hotelClassDao.insert(hotelClass);
            }
        }
    }

    @Override
    public HotelClass getBy(Integer hotelClassId) {
        return hotelClassDao.getBy(hotelClassId);
    }

    @Override
    public List<HotelClass> getAll() {
        return hotelClassDao.getAll();
    }
}
