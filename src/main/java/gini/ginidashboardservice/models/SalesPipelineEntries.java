package gini.ginidashboardservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Entity
@Data
@Table("sales_pipeline_entries")
public class SalesPipelineEntries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("sales_pipeline_entry_id")
    private Long salesPipelineEntryId;

    @Column("company_id")
    private Long companyId;

    @Column("bus_unit_name")
    private String busUnitName;

    @Column("opportunity_id")
    private Long opportunityId;

    @Column("opportunity_type")
    private String opportunityType;

    @Column("customer_id")
    private Long customerId;

    @Column("sales_agent_id")
    private Long salesAgentId;

    @Column("employee_id")
    private Long employeeId;

    @Column("product_type")
    private String productType;

    @Column("product_name")
    private String productName;

    @Column("policy_no")
    private String policyNo;

    @Column("policy_amount")
    private BigDecimal policyAmount;

    @Column("target_premium_amount")
    private BigDecimal targetPremiumAmount;

    @Column("estimated_revenue_for_sales_goal")
    private BigDecimal estimatedRevenueForSalesGoal;

    @Column("stage")
    private String stage;

    @Column("outcome")
    private String outcome;

    @Column("next_steps")
    private String nextSteps;

    @Column("notes")
    private String notes;

    @Column("created_dt")
    private LocalDateTime createdDt;

    @Column("last_modified_dt")
    private LocalDateTime lastModifiedDt;

    @Column("uw__status")
    private String uwStatus;

    @Column("uw__decision")
    private String uwDecision;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("last_modified_at")
    private LocalDateTime lastModifiedAt;

}
