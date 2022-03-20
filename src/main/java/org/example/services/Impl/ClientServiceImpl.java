package org.example.services.Impl;

import org.example.dao.extd.ClientDao;
import org.example.entities.Client;
import org.example.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public void delete(Integer clientNumber) {
        clientDao.delete(clientNumber);
    }

    @Override
    public void insert(Client client) {
        clientDao.insert(client);
    }

    @Override
    public Client getBy(Integer clientNumber) {
        return clientDao.getBy(clientNumber);
    }

    @Override
    public List getAll() {
        return clientDao.getAll();
    }

    @Override
    public void update(Client client) {
        clientDao.update(client);
    }
}
