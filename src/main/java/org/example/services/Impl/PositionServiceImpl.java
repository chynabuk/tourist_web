package org.example.services.Impl;

import org.example.dao.extd.PositionDao;
import org.example.entities.Position;
import org.example.enums.PositionTypeEnum;
import org.example.services.AddAll;
import org.example.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService{
    @Autowired
    private PositionDao positionDao;

    @Override
    public void insert(Position position) {
        positionDao.insert(position);
    }

    @Override
    public Position getBy(Integer positionId) {
        return positionDao.getBy(positionId);
    }

    @Override
    public List<Position> getAll() {
        return positionDao.getAll();
    }


    @Override
    public void addAll() {
        if (getAll().isEmpty() || getAll() == null){
            for (PositionTypeEnum positionTypeEnum : PositionTypeEnum.values()){
                Position position = new Position();
                position.setPositionType(positionTypeEnum);
                insert(position);
            }
        }
    }
}
