package org.example.services.Impl;

import org.example.dao.extd.AgreementDao;
import org.example.entities.Agreement;
import org.example.services.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AgreementServiceImpl implements AgreementService {
    @Autowired
    private AgreementDao agreementDao;

    @Override
    public void delete(Integer id) {
        agreementDao.delete(id);
    }

    @Override
    public void insert(Agreement agreement) {
        agreementDao.insert(agreement);
    }

    @Override
    public Agreement getBy(Integer id) {
        return agreementDao.getBy(id);
    }

    @Override
    public List<Agreement> getAll() {
        return agreementDao.getAll();
    }

    @Override
    public void update(Agreement agreement) {
        agreementDao.update(agreement);
    }
}
