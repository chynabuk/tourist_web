package org.example.services;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.TourFlight;

public interface TourFlightSevice extends Insertion<TourFlight>, Deletion, Update<TourFlight>, Select<TourFlight> {
}
