package com.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hr.entity.Employee;

@Repository
public interface employeeRepo extends JpaRepository<Employee, Long> {

//JPQL
	@Query(value = "select emp from Employee emp where emp.name like :name")
	List<Employee> filter(@Param("name") String name);

	// query (select emp from employee emp join emp.department dep where
	// dep.id=:depId)
	public List<Employee> findByDep_Id(Long depId);

}
