package org.example.dao.extd.impl;

import org.example.dao.extd.EmployeeDao;
import org.example.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer passportNumber) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getBy(passportNumber));
    }

    @Override
    public void insert(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    @Override
    public Employee getBy(Integer passportNumber) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, passportNumber);
        return employee;
    }

    @Override
    public List getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> employees = session.createQuery("from Employee").getResultList();
        return employees;
    }

    @Override
    public void update(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }
}
