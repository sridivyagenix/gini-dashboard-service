package gini.ginidashboardservice.service.impl;

import gini.ginidashboardservice.models.Employee;
import gini.ginidashboardservice.repositories.EmployeeRepository;
import gini.ginidashboardservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            return Optional.of(employee);
        }
        return Optional.empty();
    }
}
