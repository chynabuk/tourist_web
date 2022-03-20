package org.example.dao.extd.impl;

import org.example.dao.extd.ClientDao;
import org.example.entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Integer clientNumber) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getBy(clientNumber));
    }

    @Override
    public void insert(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.save(client);
    }

    @Override
    public Client getBy(Integer clientNumber) {
        Session session = sessionFactory.getCurrentSession();
        Client client = session.get(Client.class, clientNumber);
        return client;
    }

    @Override
    public List getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Client> clients = session.createQuery("from Client ").getResultList();
        return clients;
    }

    @Override
    public void update(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.update(client);
    }
}
