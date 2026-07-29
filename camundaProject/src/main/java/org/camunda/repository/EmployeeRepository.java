package org.camunda.repository;

import org.camunda.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
