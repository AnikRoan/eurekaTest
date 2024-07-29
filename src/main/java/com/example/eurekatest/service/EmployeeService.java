package com.example.eurekatest.service;

import com.example.eurekatest.entity.Employee;
import com.example.eurekatest.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    public final EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow((
                () -> new RuntimeException("Employee not found"))
        );
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee updateEmployee(Long id,Employee employee) {
        Employee emp = employeeRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Employee not found"));
        emp.setName(employee.getName());
        emp.setCompany(employee.getCompany());
        return employeeRepository.save(emp);
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
