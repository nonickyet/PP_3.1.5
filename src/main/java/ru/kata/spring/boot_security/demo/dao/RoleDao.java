package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleDao {
    Role getByIdRole(int id);

    List<Role> getAllRoles();

    Role getByName(String name);

    List<Role> getListByName(List<String> name);

    boolean add(Role user);

    List<Role> getRolesListById(List<Integer> roles);
}
