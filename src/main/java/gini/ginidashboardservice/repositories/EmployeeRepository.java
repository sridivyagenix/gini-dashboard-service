package gini.ginidashboardservice.repositories;

import gini.ginidashboardservice.models.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
    Mono<Employee> findById(Long employeeId);
}