package org.example.services.Impl;

import org.example.dao.extd.ProgramDao;
import org.example.entities.Program;
import org.example.services.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProgramServiceImpl implements ProgramService {
    @Autowired
    private ProgramDao programDao;

    @Override
    public void delete(Integer programNumber) {
        programDao.delete(programNumber);
    }

    @Override
    public void insert(Program program) {
        programDao.insert(program);
    }

    @Override
    public Program getBy(Integer programNumber) {
        return programDao.getBy(programNumber);
    }

    @Override
    public List<Program> getAll() {
        return programDao.getAll();
    }

    @Override
    public void update(Program program) {
        programDao.update(program);
    }
}
