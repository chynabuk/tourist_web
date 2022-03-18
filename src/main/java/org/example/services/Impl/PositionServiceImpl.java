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
        if (getAll().isEmpty()){
            Position p1 = new Position();
            p1.setPositionType(PositionTypeEnum.DEPUTY_DIRECTOR);
            insert(p1);

            Position p2 = new Position();
            p2.setPositionType(PositionTypeEnum.TOUR_MANAGER);
            insert(p2);

            Position p3 = new Position();
            p3.setPositionType(PositionTypeEnum.TOUR_PLANNER);
            insert(p3);

            Position p4 = new Position();
            p4.setPositionType(PositionTypeEnum.DEPUTY_MANAGER);
            insert(p4);
        }
    }
}
