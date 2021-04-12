package com.app.jpa.security.jpa.repository;

import com.app.jpa.security.jpa.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByName(String name);
}
