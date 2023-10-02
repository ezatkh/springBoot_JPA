package com.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.entity.Role;

@Repository
public interface roleRepo extends JpaRepository<Role, Long> {

}
