package org.example.services;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.Client;

public interface ClientService extends Insertion<Client>, Deletion, Select<Client>, Update<Client> {
}
