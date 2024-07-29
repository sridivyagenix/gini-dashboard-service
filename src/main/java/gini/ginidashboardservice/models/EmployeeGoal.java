package gini.ginidashboardservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "employee_goals")
public class EmployeeGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="employee_goal_id")
    private Long employeeGoalId;

    @Column(name ="company_id")
    private Long companyId;

    @Column(name ="team_goal_id")
    private Long teamGoalId;

    @Column(name ="employee_id")
    private Long employeeId;

    @Column(name ="target_amount")
    private BigDecimal targetAmount;

    @Column(name ="status")
    private String status;

    @Column(name ="metadata")
    private String metadata;

    @Column(name ="created_at")
    private LocalDateTime createdAt;

    @Column(name ="last_modified_at")
    private LocalDateTime lastModifiedAt;
}
