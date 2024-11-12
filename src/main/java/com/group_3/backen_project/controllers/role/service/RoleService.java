package com.group_3.backen_project.controllers.role.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Role;
import com.group_3.backen_project.repositories.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Optional<Role> geRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    public Role updateRole(Long id, Role detailrole) {
        Role role = roleRepository.findById(id).orElseThrow();
        role.setName(detailrole.getName());
        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
