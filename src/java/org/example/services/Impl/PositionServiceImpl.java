package org.example.services.Impl;

import org.example.dao.extd.PositionDao;
import org.example.entities.Position;
import org.example.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {
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
}
