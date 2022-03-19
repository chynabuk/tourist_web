package org.example.services;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.Event;

public interface EventService extends Insertion<Event>, Deletion, Update<Event>, Select<Event> {
}
