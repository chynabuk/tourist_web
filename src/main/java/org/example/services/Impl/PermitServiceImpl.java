package org.example.services.Impl;

import org.example.dao.extd.PermitDao;
import org.example.entities.Permit;
import org.example.services.PermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermitServiceImpl implements PermitService {
    @Autowired
    private PermitDao permitDao;

    @Override
    public void delete(Integer id) {
        permitDao.delete(id);
    }

    @Override
    public void insert(Permit permit) {
        permitDao.insert(permit);
    }

    @Override
    public Permit getBy(Integer id) {
        return permitDao.getBy(id);
    }

    @Override
    public List<Permit> getAll() {
        return permitDao.getAll();
    }

    @Override
    public void update(Permit permit) {
        permitDao.update(permit);
    }
}
