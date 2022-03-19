package org.example.services;

import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.entities.AviaClass;

public interface AviaClassService extends Insertion<AviaClass>, Select<AviaClass>, AddAll {
}
