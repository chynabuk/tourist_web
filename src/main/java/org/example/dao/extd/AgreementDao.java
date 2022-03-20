package org.example.dao.extd;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.Agreement;

public interface AgreementDao extends Insertion<Agreement>, Deletion, Select<Agreement>, Update<Agreement> {
}
