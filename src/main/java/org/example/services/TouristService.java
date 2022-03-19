package org.example.services;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.Tourist;

public interface TouristService extends Insertion<Tourist>, Deletion, Update<Tourist>, Select<Tourist> {
}
