package org.example.services;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.TourTask;

public interface TourTaskService extends Insertion<TourTask>, Deletion, Update<TourTask>, Select<TourTask> {
}
