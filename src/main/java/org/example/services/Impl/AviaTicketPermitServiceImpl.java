package org.example.services.Impl;

import org.example.dao.extd.AviaTicketPermitDao;
import org.example.entities.AviaTicketPermit;
import org.example.services.AviaTicketPermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AviaTicketPermitServiceImpl implements AviaTicketPermitService {
    @Autowired
    private AviaTicketPermitDao aviaTicketPermitDao;

    @Override
    public void delete(Integer id) {
        aviaTicketPermitDao.delete(id);
    }

    @Override
    public void insert(AviaTicketPermit aviaTicketPermit) {
        aviaTicketPermitDao.insert(aviaTicketPermit);
    }

    @Override
    public AviaTicketPermit getBy(Integer id) {
        return aviaTicketPermitDao.getBy(id);
    }

    @Override
    public List<AviaTicketPermit> getAll() {
        return aviaTicketPermitDao.getAll();
    }

    @Override
    public void update(AviaTicketPermit aviaTicketPermit) {
        aviaTicketPermitDao.update(aviaTicketPermit);
    }
}
