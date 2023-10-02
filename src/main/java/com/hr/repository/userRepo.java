package com.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.entity.User;

@Repository
public interface userRepo extends JpaRepository<User, Long> {
}
