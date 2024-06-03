package gini.ginidashboardservice.repositories;

import gini.ginidashboardservice.models.EmployeeGoal;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface EmployeeGoalRepository extends R2dbcRepository<EmployeeGoal, Long> {
    Mono<EmployeeGoal> findByEmployeeId(Long employeeId);
}
