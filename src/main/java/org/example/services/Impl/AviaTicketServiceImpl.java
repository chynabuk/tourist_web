package org.example.services.Impl;

import org.example.dao.extd.AviaTicketDao;
import org.example.entities.AviaTicket;
import org.example.services.AviaTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AviaTicketServiceImpl implements AviaTicketService {
    @Autowired
    private AviaTicketDao aviaTicketDao;

    @Override
    public void delete(Integer id) {
        aviaTicketDao.delete(id);
    }

    @Override
    public void insert(AviaTicket aviaTicket) {
        aviaTicketDao.insert(aviaTicket);
    }

    @Override
    public AviaTicket getBy(Integer id) {
        return aviaTicketDao.getBy(id);
    }

    @Override
    public List<AviaTicket> getAll() {
        return aviaTicketDao.getAll();
    }

    @Override
    public void update(AviaTicket aviaTicket) {
        aviaTicketDao.update(aviaTicket);
    }
}
