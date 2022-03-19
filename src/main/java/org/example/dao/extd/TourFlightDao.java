package org.example.dao.extd;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.TourFlight;

public interface TourFlightDao extends Insertion<TourFlight>, Deletion, Update<TourFlight>, Select<TourFlight> {
}
