package org.example.services;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.entities.TourType;

public interface TourTypeService extends Insertion<TourType>, Deletion, Select<TourType>, AddAll {
}
