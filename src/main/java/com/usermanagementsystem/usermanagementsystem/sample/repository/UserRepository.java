package com.usermanagementsystem.usermanagementsystem.sample.repository;

import com.usermanagementsystem.usermanagementsystem.sample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
