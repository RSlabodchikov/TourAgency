package com.bsuir.course.service;

import com.bsuir.course.entity.Role;

import java.util.Optional;

public interface RoleService {
    Iterable<Role> getAllRoles();
    Optional<Role> getRoleById(Long id);
}
