package org.example.services;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.Tour;

public interface TourService extends Insertion<Tour>, Deletion, Update<Tour>, Select<Tour> {
}
