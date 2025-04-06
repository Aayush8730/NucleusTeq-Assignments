package com.example.HRportal.repo;

import com.example.HRportal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
        Optional<Employee> findByEmailAndPassword(String email, String password);
}