package com.frobom.campanio.repository;

import com.frobom.campanio.entity.Role;

public interface RoleRepository {

    void save(Role role);
    
    Role findById(int id);
    
    Role findByName(String name);
    
    Role getDefaultRole();

    Role getAdminRole();
}
