package com.example.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.employeemanager.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);

    List<Employee> findAllByNameContaining(String name);

    // public static final String FIND_EMPLOYEE_MAIL = " 2";

    @Query(value = "SELECT email FROM employee where id <> ?1", nativeQuery = true)
    List<String> findRmployeeEmails(Long id);
}
