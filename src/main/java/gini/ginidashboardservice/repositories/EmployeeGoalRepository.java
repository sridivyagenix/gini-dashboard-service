package gini.ginidashboardservice.repositories;

import gini.ginidashboardservice.models.EmployeeGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface EmployeeGoalRepository extends JpaRepository<EmployeeGoal, Long> {

    @Query(value = "SELECT SUM(target_amount)" +
            "FROM employee_goals e " +
            "WHERE e.employee_id = :employeeId " +
            "AND e.yr = YEAR(CURRENT_DATE) " +
            "AND e.month <= MONTH(CURRENT_DATE)",
            nativeQuery = true)
    BigDecimal calculateSumOfGoalsByEmployeeId(@Param("employeeId") Long employeeId);
}
