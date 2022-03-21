package org.example.services.Impl;

import org.example.dao.extd.PermitTicketDao;
import org.example.entities.PermitTicket;
import org.example.services.PermitTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermitTicketServiceImpl implements PermitTicketService {
    @Autowired
    private PermitTicketDao permitTicketDao;

    @Override
    public void delete(Integer id) {
        permitTicketDao.delete(id);
    }

    @Override
    public void insert(PermitTicket permitTicket) {
        permitTicketDao.insert(permitTicket);
    }

    @Override
    public PermitTicket getBy(Integer id) {
        return permitTicketDao.getBy(id);
    }

    @Override
    public List<PermitTicket> getAll() {
        return permitTicketDao.getAll();
    }

    @Override
    public void update(PermitTicket permitTicket) {
        permitTicketDao.update(permitTicket);
    }
}
