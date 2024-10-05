package gini.ginidashboardservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PipelineDashboardResponse {
    BigDecimal PipelineSales;
    long appsSales = 7;
    String healthSales = "Robust";
    String  conversationRate = "65%";
}
