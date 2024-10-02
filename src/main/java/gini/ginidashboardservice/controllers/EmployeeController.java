package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.dto.Meetings;
import gini.ginidashboardservice.models.Employee;
import gini.ginidashboardservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
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

    @GetMapping("/meetings")
    public List<Meetings> getDummyData() {
        Meetings event1 = new Meetings("Today 1:00 pm to 1:30 pm", "Large case placement", "meet.google.com/abc-def-qaw");
        Meetings event2 = new Meetings("Today 1:00 pm to 1:30 pm", "Large case placement", "meet.google.com/abc-def-qaw");

        return Arrays.asList(event1, event2);
    }
}
