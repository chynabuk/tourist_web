package org.example.dao.extd;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.Hotel;

public interface HotelDao extends Insertion<Hotel>, Deletion, Update<Hotel>, Select<Hotel> {
}
