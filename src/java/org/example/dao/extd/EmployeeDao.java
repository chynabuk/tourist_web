package org.example.dao.extd;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.Employee;

public interface EmployeeDao extends Insertion<Employee>, Deletion, Update, Select<Employee> {
}
