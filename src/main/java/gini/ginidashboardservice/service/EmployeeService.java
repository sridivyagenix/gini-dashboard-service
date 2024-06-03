package gini.ginidashboardservice.service;

import gini.ginidashboardservice.models.Employee;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<Employee> getEmployeeById(Long employeeId);
}
