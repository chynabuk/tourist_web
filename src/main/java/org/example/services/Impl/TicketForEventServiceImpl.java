package org.example.services.Impl;

import org.example.dao.extd.TicketForEventDao;
import org.example.entities.TicketForEvent;
import org.example.services.TicketForEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TicketForEventServiceImpl implements TicketForEventService {
    @Autowired
    private TicketForEventDao ticketForEventDao;

    @Override
    public void delete(Integer ticketNumber) {
        ticketForEventDao.delete(ticketNumber);
    }

    @Override
    public void insert(TicketForEvent ticketForEvent) {
        ticketForEventDao.insert(ticketForEvent);
    }

    @Override
    public TicketForEvent getBy(Integer ticketNumber) {
        return ticketForEventDao.getBy(ticketNumber);
    }

    @Override
    public List<TicketForEvent> getAll() {
        return ticketForEventDao.getAll();
    }

    @Override
    public void update(TicketForEvent ticketForEvent) {
        ticketForEventDao.update(ticketForEvent);
    }
}
