package org.example.services;

import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.entities.Position;

public interface PositionService extends Insertion<Position>, Select<Position> {
}
