package ru.itmentor.spring.boot_security.demo.servise;

import ru.itmentor.spring.boot_security.demo.models.Role;

import java.util.Set;

public interface RoleService {

    Set<Role> getAllRoles();
    Set<Role> getRoleByName(String[] roleName);
}
