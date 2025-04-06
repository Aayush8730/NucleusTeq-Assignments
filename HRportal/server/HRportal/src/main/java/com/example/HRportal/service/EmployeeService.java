package com.example.HRportal.service;

import com.example.HRportal.model.Employee;
import com.example.HRportal.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> login(String email, String password) {
        return employeeRepository.findByEmailAndPassword(email, password);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> updateEmployee(Long id, Employee updated) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updated.getName());
            employee.setEmail(updated.getEmail());
            employee.setDepartment(updated.getDepartment());
            employee.setSalary(updated.getSalary());
            return employeeRepository.save(employee);
        });
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
