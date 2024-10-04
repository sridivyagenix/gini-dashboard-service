package gini.ginidashboardservice.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
@Data
public class PipelineDashboardResponse {
    BigDecimal PipelineSales;
    private BigDecimal appsSales = new BigDecimal("45800000.00");
    private BigDecimal healthSales = new BigDecimal("45800000.00");
    private BigDecimal conversationRate = new BigDecimal("45800000.00");
}
