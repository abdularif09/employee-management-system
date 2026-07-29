package suthentication.service;

import org.springframework.data.jpa.repository.JpaRepository;
import suthentication.entity.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeService  {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    Optional<Employee> getEmployeeById(String employeeId);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
}
