package com.example.employee_management.service;

import com.example.employee_management.model.Employee;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import com.example.employee_management.repository.EmployeeJdbcDao;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeJdbcDao employeeJdbcDao;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeJdbcDao employeeJdbcDao) {
        this.employeeRepository = employeeRepository;
        this.employeeJdbcDao = employeeJdbcDao;
    }

    @PostConstruct
    public void init() {
        System.out.println("EmployeeService Bean Created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("EmployeeService Bean Destroyed");
    }

    // CRUD using JPA
    public Employee addEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // JDBC example
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeJdbcDao.findAllByDepartment(department);
    }
}