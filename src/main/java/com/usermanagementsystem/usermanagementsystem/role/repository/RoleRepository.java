package com.usermanagementsystem.usermanagementsystem.role.repository;

import com.usermanagementsystem.usermanagementsystem.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
