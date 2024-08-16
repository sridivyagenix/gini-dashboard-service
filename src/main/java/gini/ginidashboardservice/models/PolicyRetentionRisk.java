package gini.ginidashboardservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "policy_retention_risks", schema = "axonai_demo")
public class PolicyRetentionRisk {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long policyRetentionRiskId;

    private Long companyId;

    private String policyId;

    private String policyholderName;

    private BigDecimal surrenderProbablityPct;

    private Short predictedSurrenderTimeframeMos;

    private BigDecimal predictedCashValue;

    private String productType;

    private String predictedReason;

    private Short policyDurationYrs;

    private BigDecimal premiumPaidToDate;

    private Short policyholderAge;

    private BigDecimal policyHolderIncome;

    private String recommendedAction;

    private Timestamp createdAt;

    private Timestamp lastModifiedAt;

}
