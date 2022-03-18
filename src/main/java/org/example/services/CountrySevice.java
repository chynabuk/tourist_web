package org.example.services;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.entities.Country;

public interface CountrySevice extends Insertion<Country>, Deletion, Select<Country>, AddAll {
}
