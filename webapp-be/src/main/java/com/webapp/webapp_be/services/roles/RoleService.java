package com.webapp.webapp_be.services.roles;

import com.webapp.webapp_be.dto.RoleDTO;
import com.webapp.webapp_be.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService{
    @Override
    public Role createRole(RoleDTO roleDTO) {
        return null;
    }

    @Override
    public Role updateRole(Long roleId, RoleDTO roleDTO) {
        return null;
    }

    @Override
    public Role getRoleById(Long roleId) {
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return List.of();
    }
}
