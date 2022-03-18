package org.example.services.Impl;

import org.example.dao.extd.EmployeeDao;
import org.example.entities.Employee;
import org.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void insert(Employee employee) {
        employeeDao.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(Integer passportNumber) {
        employeeDao.delete(passportNumber);
    }

    @Override
    public Employee getBy(Integer passportNumber) {
        return employeeDao.getBy(passportNumber);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }
}
