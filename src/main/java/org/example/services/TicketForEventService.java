package org.example.services;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.TicketForEvent;

public interface TicketForEventService extends Insertion<TicketForEvent>, Deletion, Update<TicketForEvent>, Select<TicketForEvent> {
}
