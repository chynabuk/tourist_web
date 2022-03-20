package org.example.services;

import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.entities.HotelNumberCategory;

public interface HotelNumberCategoryService extends Insertion<HotelNumberCategory>, Select<HotelNumberCategory>, AddAll {
}
