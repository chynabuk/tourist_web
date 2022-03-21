package org.example.services;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.HotelNumber;

public interface HotelNumberService extends Insertion<HotelNumber>, Deletion, Update<HotelNumber>, Select<HotelNumber> {
}
