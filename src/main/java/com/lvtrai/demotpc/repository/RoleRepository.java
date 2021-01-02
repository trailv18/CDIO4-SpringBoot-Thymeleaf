package com.lvtrai.demotpc.repository;

import org.springframework.data.repository.CrudRepository;

import com.lvtrai.demotpc.security.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findByName(String name);

}
