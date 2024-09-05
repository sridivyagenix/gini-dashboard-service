package gini.ginidashboardservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class ClientProfileDTO {

    private Long companyId;
    private Long employeeId;
    private Long agentId;
    private String fullName;
    private LocalDate dob;
    private String taxId;
    private String gender;
    private String maritalStatus;
    private String phone;
    private String email;
    private String occupation;
    private BigDecimal annualIncome;
    private Map<String, Object> address;
    private Map<String, Object> employer;
    private List<Map<String, Object>> insuranceCoverageDetails;
    private Map<String, Object> beneficiaries;
    private Map<String, Object> healthInfo;
    private Map<String, Object> lifestyleBackgroundInfo;
    private Map<String, Object> declarations;
    private List<Map<String, Object>> children;
    private Map<String, Object> savings;
    private Map<String, Object> monthlyExpenses;
    private Map<String, Object> insuranceGoals;
    private Map<String, Object> retirementGoals;
    private Map<String, Object> investmentGoals;
    private Map<String, Object> riskAppetite;
    private Map<String, Object> financialGoals;
    private String additionalInfo;
    private LocalDateTime profileUpdatedDt;
    private LocalDateTime lastModifiedAt;
}