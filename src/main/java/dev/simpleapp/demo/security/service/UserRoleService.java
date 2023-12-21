package dev.simpleapp.demo.security.service;

import dev.simpleapp.demo.security.model.UserRole;

import java.util.Optional;

public interface UserRoleService {
    Optional<UserRole> findUserRole();
}
