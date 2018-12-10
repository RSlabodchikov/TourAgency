package com.bsuir.course.controller;

import com.bsuir.course.entity.Client;
import com.bsuir.course.entity.Room;
import com.bsuir.course.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Client> getAllClients() {
        return service.findAllClients();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteClientById(@PathVariable(name = "id")Long id) {
        service.deleteClientById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Client saveClient(@RequestBody Client client){
        return service.saveClient(client);
    }

    @RequestMapping(value="/{id}", method =RequestMethod.GET)
    public ResponseEntity<Client> getClientById(@PathVariable("id")Long id){
        Optional<Client>client=service.findClientById(id);
        if (client.isPresent()){
            return ResponseEntity.ok(client.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
