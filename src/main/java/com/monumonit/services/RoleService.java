package com.monumonit.services;

import com.monumonit.entities.Role;
import com.monumonit.repositories.RoleRepository;
import com.monumonit.services.common.AbstractShortIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RoleService extends AbstractShortIdService<Role> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    protected JpaRepository<Role, Integer> getRepository() {
        return roleRepository;
    }
}
