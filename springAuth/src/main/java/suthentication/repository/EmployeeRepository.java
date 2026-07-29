package suthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import suthentication.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmployeeId(String employeeId);
}
