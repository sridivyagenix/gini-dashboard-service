package gini.ginidashboardservice.service;

import gini.ginidashboardservice.models.Employee;

import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> getEmployeeById(Long employeeId);
}
