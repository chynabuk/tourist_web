package org.example.services;

import org.example.dao.Deletion;
import org.example.dao.Insertion;
import org.example.dao.Select;
import org.example.dao.Update;
import org.example.entities.Employee;

public interface EmployeeService extends Select<Employee>, Insertion<Employee>, Deletion, Update<Employee> {
}
