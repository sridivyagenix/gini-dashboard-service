package gini.ginidashboardservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "employee_goals")
public class EmployeeGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("employee_goal_id")
    private Long employeeGoalId;

    @Column("company_id")
    private Long companyId;

    @Column("team_goal_id")
    private Long teamGoalId;

    @Column("employee_id")
    private Long employeeId;

    @Column("target_amount")
    private BigDecimal targetAmount;

    @Column("status")
    private String status;

    @Column("metadata")
    private String metadata;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("last_modified_at")
    private LocalDateTime lastModifiedAt;
}
