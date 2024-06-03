package gini.ginidashboardservice.service.impl;

import gini.ginidashboardservice.dto.SalesDashboardResponse;
import gini.ginidashboardservice.models.EmployeeGoal;
import gini.ginidashboardservice.models.SalesPipelineEntries;
//import gini.ginidashboardservice.repositories.EmployeeGoalRepository;
import gini.ginidashboardservice.repositories.EmployeeGoalRepository;
import gini.ginidashboardservice.repositories.EmployeeGoalsDenormRepository;
import gini.ginidashboardservice.repositories.SalesPipelineEntriesRepository;
import gini.ginidashboardservice.service.SalesService;
import gini.ginidashboardservice.utils.CalculateDates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements SalesService{
    private final SalesPipelineEntriesRepository salesPipelineEntryRepository;
    private final EmployeeGoalRepository employeeGoalRepository;
    private final CalculateDates calculateDates;
    private final EmployeeGoalsDenormRepository employeeGoalDenormRepository;

    @Override
    public Mono<SalesDashboardResponse> getSalesInfo(Long employeeId) {
        return Mono.zip(
                getTotalTargetPremiumAmountByEmployeeIdAndCurrentYear(employeeId),
                getDistinctPolicyCountByEmployeeIdAndYear(employeeId),
                getTargetAmountByEmployeeId(employeeId),
                getEmployeeMonthlyGoalAmount(employeeId)
        ).map(values -> {
            BigDecimal currentSales = values.getT1();
            Long totalSales = values.getT2();
            BigDecimal goal = values.getT3();
            BigDecimal monthlyGoal = values.getT4();

            SalesDashboardResponse response = new SalesDashboardResponse();
            response.setCurrentSales(currentSales);
            response.setTotalNumberOfSales(totalSales);
            response.setGoal(goal);
            response.setMonthlyGoal(monthlyGoal);

            BigDecimal difference = currentSales.subtract(monthlyGoal);
            BigDecimal percentage = difference
                    .divide(goal, 2, RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(100));
            response.setDrop(percentage);

            return response;
        });
    }

    private Mono<BigDecimal> getTotalTargetPremiumAmountByEmployeeIdAndCurrentYear(Long employeeId) {
        return salesPipelineEntryRepository.findByEmployeeIdAndCreatedDtBetweenAndStage(employeeId, calculateDates.getStartDate(), calculateDates.getEndDate(), "Closed Won")
                .map(SalesPipelineEntries::getTargetPremiumAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Mono<Long> getDistinctPolicyCountByEmployeeIdAndYear(Long employeeId) {
        return salesPipelineEntryRepository.countDistinctPolicyNoByEmployeeIdAndCreatedDtBetweenAndStage(employeeId, calculateDates.getStartDate(), calculateDates.getEndDate(), "Closed Won");
    }

    private Mono<BigDecimal> getTargetAmountByEmployeeId(Long employeeId) {
        return employeeGoalRepository.findByEmployeeId(employeeId)
                .map(EmployeeGoal::getTargetAmount)
                .defaultIfEmpty(BigDecimal.ZERO);
    }
    private Mono<BigDecimal> getEmployeeMonthlyGoalAmount(Long employeeId) {
        return employeeGoalDenormRepository.calculateSumOfGoalsByEmployeeId(employeeId);
    }
}
