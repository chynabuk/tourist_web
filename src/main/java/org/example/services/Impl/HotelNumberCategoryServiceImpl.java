package org.example.services.Impl;

import org.example.dao.extd.HotelNumberCategoryDao;
import org.example.entities.HotelNumberCategory;
import org.example.enums.HotelNumberCategoryEnum;
import org.example.services.HotelNumberCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelNumberCategoryServiceImpl implements HotelNumberCategoryService {
    @Autowired
    private HotelNumberCategoryDao hotelNumberCategoryDao;

    @Override
    public void insert(HotelNumberCategory hotelNumberCategory) {
        hotelNumberCategoryDao.insert(hotelNumberCategory);
    }

    @Override
    public HotelNumberCategory getBy(Integer id) {
        return hotelNumberCategoryDao.getBy(id);
    }

    @Override
    public List<HotelNumberCategory> getAll() {
        return hotelNumberCategoryDao.getAll();
    }

    @Override
    public void addAll() {
        if (getAll().isEmpty() || getAll() == null){
            for ( HotelNumberCategoryEnum hotelNumberCategoryEnum : HotelNumberCategoryEnum.values()){
                HotelNumberCategory hotelNumberCategory = new HotelNumberCategory();
                hotelNumberCategory.setHotelNumberCategoryEnum(hotelNumberCategoryEnum);
                insert(hotelNumberCategory);
            }
        }
    }
}
