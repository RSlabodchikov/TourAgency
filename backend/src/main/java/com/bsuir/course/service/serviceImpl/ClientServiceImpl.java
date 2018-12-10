package com.bsuir.course.service.serviceImpl;

import com.bsuir.course.entity.Client;
import com.bsuir.course.repository.ClientRepository;
import com.bsuir.course.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deleteClientById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Client> findAllClients() {
        return repository.findAll();
    }

    @Override
    public Optional<Client> findClientById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Client saveClient(Client client) {
        return repository.save(client);
    }
}
