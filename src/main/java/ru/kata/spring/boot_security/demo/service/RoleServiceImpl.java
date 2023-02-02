package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;


    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public List<Role> getListRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public List<Role> getRolesListById(List<Integer> id) {
        return roleDao.getRolesListById(id);
    }

    @Override
    public Role getRoleById(int id) {
        return roleDao.getByIdRole(id);
    }
}

