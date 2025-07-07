package com.usermanagementsystem.usermanagementsystem.user.repository;

import com.usermanagementsystem.usermanagementsystem.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String username);

    Page<User> findAllByNameContainingIgnoreCase(String keyword,Pageable pageable);


}
