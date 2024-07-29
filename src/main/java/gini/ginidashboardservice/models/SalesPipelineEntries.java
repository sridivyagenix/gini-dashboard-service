package gini.ginidashboardservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name ="sales_pipeline_entries")
public class SalesPipelineEntries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="sales_pipeline_entry_id")
    private Long salesPipelineEntryId;

    @Column(name ="company_id")
    private Long companyId;

    @Column(name ="bus_unit_name")
    private String busUnitName;

    @Column(name ="opportunity_id")
    private Long opportunityId;

    @Column(name ="opportunity_type")
    private String opportunityType;

    @Column(name ="customer_id")
    private Long customerId;

    @Column(name ="sales_agent_id")
    private Long salesAgentId;

    @Column(name ="employee_id")
    private Long employeeId;

    @Column(name ="product_type")
    private String productType;

    @Column(name ="product_name")
    private String productName;

    @Column(name ="policy_no")
    private String policyNo;

    @Column(name ="policy_amount")
    private BigDecimal policyAmount;

    @Column(name ="target_premium_amount")
    private BigDecimal targetPremiumAmount;

    @Column(name ="estimated_revenue_for_sales_goal")
    private BigDecimal estimatedRevenueForSalesGoal;

    @Column(name = "stage")
    private String stage;

    @Column(name = "outcome")
    private String outcome;

    @Column(name = "next_steps")
    private String nextSteps;

    @Column(name = "notes")
    private String notes;

    @Column(name = "created_dt")
    private LocalDateTime createdDt;

    @Column(name = "last_modified_dt")
    private LocalDateTime lastModifiedDt;

    @Column(name = "uw__status")
    private String uwStatus;

    @Column(name = "uw__decision")
    private String uwDecision;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

}
