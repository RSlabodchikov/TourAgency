package com.bsuir.course.service.serviceImpl;


import com.bsuir.course.entity.Role;
import com.bsuir.course.repository.RoleRepository;
import com.bsuir.course.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Role> getAllRoles() {
        return repository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(Long id) {
        return repository.findById(id);
    }
}
