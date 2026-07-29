package suthentication.dao;

import org.springframework.stereotype.Service;
import suthentication.entity.Employee;
import suthentication.repository.EmployeeRepository;
import suthentication.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Employee> getEmployeeById(String employeeId) {
        return repository.findByEmployeeId(employeeId);

    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee dbEmployee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        dbEmployee.setEmployeeName(employee.getEmployeeName());
        dbEmployee.setEmail(employee.getEmail());
        dbEmployee.setMobileNumber(employee.getMobileNumber());
        dbEmployee.setDepartment(employee.getDepartment());
        dbEmployee.setDesignation(employee.getDesignation());
        dbEmployee.setManager(employee.getManager());
        dbEmployee.setLocation(employee.getLocation());

        return repository.save(dbEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
