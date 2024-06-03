package gini.ginidashboardservice.service.impl;

import gini.ginidashboardservice.models.Employee;
import gini.ginidashboardservice.repositories.EmployeeRepository;
import gini.ginidashboardservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Mono<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                    Employee response = new Employee();
                    response.setEmployeeId(employee.getEmployeeId());
                    response.setEmployeeName(employee.getEmployeeName());
                    response.setEmail(employee.getEmail());
                    response.setLastModifiedAt(employee.getLastModifiedAt());
                    return response;
                });
    }
}
