package com.hr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hr.entity.Employee;

@Repository
public interface employeeRepo extends CrudRepository<Employee, Long> {

}
