package org.example.services;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.AviaTicket;

public interface AviaTicketService extends Insertion<AviaTicket>, Deletion, Update<AviaTicket>, Select<AviaTicket> {
}
