package com.bsuir.course.controller;


import com.bsuir.course.entity.Role;
import com.bsuir.course.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {


    private RoleService service;

    @Autowired
    public RoleController(RoleService service) {
        this.service = service;
    }

    @RequestMapping(value="",method = RequestMethod.GET)
    public Iterable<Role> getAllRoles() {
        return service.getAllRoles();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Role> getRoleById(@PathVariable(name = "id") Long id) {
        Optional<Role> role = service.getRoleById(id);
        if (role.isPresent()) {
            return ResponseEntity.ok(role.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
