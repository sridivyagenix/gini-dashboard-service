package gini.ginidashboardservice.repositories;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Repository
public class EmployeeGoalRepository {
    private final ConnectionFactory connectionFactory;

    public EmployeeGoalRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public Mono<BigDecimal> calculateSumOfGoalsByEmployeeId(Long employeeId) {
        return Mono.from(connectionFactory.create())
                .flatMapMany(connection -> {
                    String sql = "SELECT SUM(individual_goal_amount) " +
                            "FROM employee_goals_denorm " +
                            "WHERE employee_id = '" + employeeId + "' " +
                            "AND yr = YEAR(CURRENT_DATE) " +
                            "AND month <= MONTH(CURRENT_DATE)";
                    return connection.createStatement(sql)
                            .execute();
                })
                .flatMap(result -> result.map((row, rowMetadata) ->
                        row.get("SUM(individual_goal_amount)", BigDecimal.class)
                ))
                .single();
    }
}

