package com.demo.springsecurityexample.repository;


import com.demo.springsecurityexample.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends JpaRepository<UserRoles, Long> {
   Set<UserRoles> getUserRolesByUserId(long id);
}
