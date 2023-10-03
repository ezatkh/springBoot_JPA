package com.hr.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;

@Table(name = "employee")
@Entity
@SqlResultSetMapping(name = "EmployeeMapping", entities = @EntityResult(entityClass = Employee.class, fields = {
		@FieldResult(name = "id", column = "id"), @FieldResult(name = "user.id", column = "user_id"),
		@FieldResult(name = "dep.id", column = "deb_id"), @FieldResult(name = "name", column = "name"),
		@FieldResult(name = "salary", column = "salary"), }))
@NamedNativeQuery(name = "Employee.findBySalary", query = "select empQuery.name,empQuery.salary from Employee empQuery where empQuery.salary>= :salary", resultSetMapping = "EmployeeMapping")

@NamedQuery(name = "Employee.countBySalary", query = "select count(emp) from Employee emp where emp.salary>= :salary")

public class Employee {
	String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dep_id", referencedColumnName = "id")
	// @JsonIgnore
	Department dep;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	long id;
	@Column(name = "Salary")
	double salary;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
