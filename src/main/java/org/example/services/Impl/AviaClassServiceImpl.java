package org.example.services.Impl;

import org.example.dao.extd.AviaClassDao;
import org.example.entities.AviaClass;
import org.example.enums.AviaClassEnum;
import org.example.services.AviaClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AviaClassServiceImpl implements AviaClassService {
    @Autowired
    private AviaClassDao aviaClassDao;

    @Override
    public void insert(AviaClass aviaClass) {
        aviaClassDao.insert(aviaClass);
    }

    @Override
    public AviaClass getBy(Integer aviaClassId) {
        return aviaClassDao.getBy(aviaClassId);
    }

    @Override
    public List<AviaClass> getAll() {
        return aviaClassDao.getAll();
    }

    @Override
    public void addAll() {
        if (getAll().isEmpty() || getAll() == null){
            for (AviaClassEnum aviaClassEnum : AviaClassEnum.values()){
                AviaClass aviaClass = new AviaClass();
                aviaClass.setAviaClassEnum(aviaClassEnum);
                insert(aviaClass);
            }
        }
    }
}
