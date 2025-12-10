package com.webapp.webapp_be.services.roles;

import com.webapp.webapp_be.dto.RoleDTO;
import com.webapp.webapp_be.models.Role;

import java.util.List;

public interface IRoleService {
    Role createRole(RoleDTO roleDTO);
    Role updateRole(Long roleId, RoleDTO roleDTO);
    Role getRoleById(Long roleId);
    List<Role> getAllRoles();
}
