package org.example.dao.extd;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.PermitTicket;

public interface PermitTicketDao extends Insertion<PermitTicket>, Deletion, Select<PermitTicket>, Update<PermitTicket> {
}
