package org.example.services;

import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.entities.HotelClass;

public interface HotelClassService extends Insertion<HotelClass>, Select<HotelClass>, AddAll {
}
