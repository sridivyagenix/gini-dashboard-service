package gini.ginidashboardservice.models;
import gini.ginidashboardservice.utils.JsonConverter;
import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "client_profiles")
public class ClientProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
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

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> address;

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> employer;

    @Convert(converter = JsonConverter.class)
    private List<Map<String, Object>> insuranceCoverageDetails;

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> beneficiaries;

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> healthInfo;

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> lifestyleBackgroundInfo;

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> declarations;

    @Convert(converter = JsonConverter.class)
    private List<Map<String, Object>> children;

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> savings;

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> monthlyExpenses;

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> insuranceGoals;

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> retirementGoals;

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> investmentGoals;

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> riskAppetite;

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> financialGoals;

    private String additionalInfo;
    private LocalDateTime profileCreatedDt;
    private LocalDateTime profileUpdatedDt;

    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
}
