package org.example.services.Impl;

import org.example.dao.extd.EventDao;
import org.example.entities.Event;
import org.example.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {
    @Autowired
    private EventDao eventDao;

    @Override
    public void delete(Integer eventId) {
        eventDao.delete(eventId);
    }

    @Override
    public void insert(Event event) {
        eventDao.insert(event);
    }

    @Override
    public Event getBy(Integer eventId) {
        return eventDao.getBy(eventId);
    }

    @Override
    public List<Event> getAll() {
        return eventDao.getAll();
    }

    @Override
    public void update(Event event) {
        eventDao.update(event);
    }
}
