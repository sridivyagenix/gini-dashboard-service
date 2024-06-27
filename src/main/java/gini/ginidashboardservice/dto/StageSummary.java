package gini.ginidashboardservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageSummary {
    private String stage;
    private Long policyCount;
    private BigDecimal premiumSum;
}