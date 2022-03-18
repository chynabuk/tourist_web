package org.example.dao.extd;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.entities.Country;

public interface CountryDao extends Insertion<Country>, Deletion, Select<Country> {
}
