package gini.ginidashboardservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table("employee_goals_denorm")
public class EmployeeGoalsDenorm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("employee_goal_id")
    private Long employeeGoalId;

    @Column("company_id")
    private Long companyId;

    @Column("team_goal_id")
    private String teamGoalId;

    @Column("bus_unit_goal_id")
    private String busUnitGoalId;

    @Column("team_id")
    private Integer teamId;

    @Column("employee_id")
    private Long employeeId;

    @Column("yr")
    private Integer yr;

    @Column("month")
    private Integer month;

    @Column("individual_goal_amount")
    private BigDecimal individualGoalAmount;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("last_modified_at")
    private LocalDateTime lastModifiedAt;
}