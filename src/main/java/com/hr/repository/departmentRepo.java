package com.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.entity.Department;

@Repository
public interface departmentRepo extends JpaRepository<Department, Long> {

}
