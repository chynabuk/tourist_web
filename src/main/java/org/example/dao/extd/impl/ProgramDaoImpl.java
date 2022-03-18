package org.example.dao.extd.impl;

import org.example.dao.extd.ProgramDao;
import org.example.entities.Program;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProgramDaoImpl implements ProgramDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer programNumber) {
        Session session = sessionFactory.getCurrentSession();
        Program program = getBy(programNumber);
        session.delete(program);
    }

    @Override
    public void insert(Program program) {
        Session session = sessionFactory.getCurrentSession();
        session.save(program);
    }

    @Override
    public Program getBy(Integer programNumber) {
        Session session = sessionFactory.getCurrentSession();
        Program program = session.get(Program.class, programNumber);
        return program;
    }

    @Override
    public List<Program> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Program> programs = session.createQuery("from Program").getResultList();
        return programs;
    }

    @Override
    public void update(Program program) {
        Session session = sessionFactory.getCurrentSession();
        session.update(program);
    }
}
