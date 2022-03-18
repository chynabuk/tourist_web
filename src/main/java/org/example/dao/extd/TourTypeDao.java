package org.example.dao.extd;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.entities.TourType;

public interface TourTypeDao extends Insertion<TourType>, Deletion, Select<TourType> {
}