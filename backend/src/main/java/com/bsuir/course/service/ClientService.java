package com.bsuir.course.service;

import com.bsuir.course.entity.Client;

import java.util.Optional;

public interface ClientService {
    void deleteClientById(Long id);
    Iterable<Client> findAllClients();
    Optional<Client> findClientById(Long id);
    Client saveClient(Client client);
}
