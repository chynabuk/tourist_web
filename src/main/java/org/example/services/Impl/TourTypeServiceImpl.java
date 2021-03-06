package org.example.services.Impl;

import org.example.dao.extd.TourTypeDao;
import org.example.entities.TourType;
import org.example.enums.TourTypeEnum;
import org.example.services.TourTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TourTypeServiceImpl implements TourTypeService {
    @Autowired
    private TourTypeDao tourTypeDao;

    @Override
    public void delete(Integer tourTypeId) {
        tourTypeDao.delete(tourTypeId);
    }

    @Override
    public void insert(TourType tourType) {
        tourTypeDao.insert(tourType);
    }

    @Override
    public TourType getBy(Integer tourTypeId) {
        return tourTypeDao.getBy(tourTypeId);
    }

    @Override
    public List<TourType> getAll() {
        return tourTypeDao.getAll();
    }

    @Override
    public void addAll() {
        if (getAll().isEmpty() || getAll() == null){
            for (TourTypeEnum tourTypeEnum : TourTypeEnum.values()){
                TourType tourType = new TourType();
                tourType.setTourTypeEnum(tourTypeEnum);
                insert(tourType);
            }
        }
    }
}
