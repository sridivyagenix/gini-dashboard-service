package gini.ginidashboardservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "sales_agents", schema = "axonai_demo")
public class SalesAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_agent_id")
    private Long salesAgentId;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "distributor_id")
    private Long distributorId;

    @Column(name = "agent_name")
    private String agentName;

    @Column(name = "license_no")
    private String licenseNo;

    @Column(name = "agent_type")
    private String agentType;

    @Column(name = "territory")
    private String territory;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "ms_teams")
    private String msTeams;

    @Column(name = "performance_segment")
    private String performanceSegment;

    @Column(name = "prev_year")
    private Integer prevYear;

    @Column(name = "prev_year_sales_amount")
    private BigDecimal prevYearSalesAmount;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "last_modified_at")
    private Timestamp lastModifiedAt;

    @Column(name = "Column6")
    private String column6;
}