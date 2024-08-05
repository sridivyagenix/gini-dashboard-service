package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.models.Employee;
import gini.ginidashboardservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@RequestHeader("X-Username") Long loggedInEmployeeId, @PathVariable("id") Long employeeId) {
        if (!employeeId.equals(loggedInEmployeeId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }
}
