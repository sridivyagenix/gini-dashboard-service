package gini.ginidashboardservice.service.impl;

import gini.ginidashboardservice.dto.SalesDashboardResponse;
import gini.ginidashboardservice.models.SalesPipelineEntries;
import gini.ginidashboardservice.repositories.EmployeeGoalRepository;
import gini.ginidashboardservice.repositories.SalesPipelineEntriesRepository;
import gini.ginidashboardservice.service.SalesService;
import gini.ginidashboardservice.utils.CalculateDates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements SalesService{
    private final SalesPipelineEntriesRepository salesPipelineEntryRepository;
    private final EmployeeGoalRepository employeeGoalRepository;
    private final CalculateDates calculateDates;
    private final EmployeeGoalRepository employeeGoalDenormRepository;

    @Override
    public SalesDashboardResponse getSalesInfo(Long employeeId) {
        // Call each method synchronously
        BigDecimal currentSales = getTotalTargetPremiumAmountByEmployeeIdAndCurrentYear(employeeId);
        Long totalSales = getDistinctPolicyCountByEmployeeIdAndYear(employeeId);
        BigDecimal goal = getTargetAmountByEmployeeId(employeeId);

        // Create and populate the response object
        SalesDashboardResponse response = new SalesDashboardResponse();
        response.setCurrentSales(currentSales);
        response.setTotalNumberOfSales(totalSales);
        response.setGoal(goal);

        // Calculate the difference and percentage drop
        BigDecimal difference = currentSales.subtract(goal);
        BigDecimal percentage = BigDecimal.ZERO;
        if (goal.compareTo(BigDecimal.ZERO) > 0) {
            percentage = difference
                    .divide(goal, 2, RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(100));
        }
        response.setDrop(percentage);

        return response;
    }

    private BigDecimal getTotalTargetPremiumAmountByEmployeeIdAndCurrentYear(Long employeeId) {
        // Fetch all the sales pipeline entries based on the criteria
        List<SalesPipelineEntries> entries = salesPipelineEntryRepository.findByEmployeeIdAndCreatedDtBetweenAndStage(
                employeeId,
                calculateDates.getStartDate(),
                calculateDates.getEndDate(),
                "Closed Won");

        // Calculate the total target premium amount
        return entries.stream()
                .map(SalesPipelineEntries::getTargetPremiumAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    private Long getDistinctPolicyCountByEmployeeIdAndYear(Long employeeId) {
        // Fetch the count of distinct policy numbers synchronously
        return salesPipelineEntryRepository.countDistinctPolicyNoByEmployeeIdAndCreatedDtBetweenAndStage(
                employeeId,
                calculateDates.getStartDate(),
                calculateDates.getEndDate(),
                "Closed Won");
    }

    private BigDecimal getTargetAmountByEmployeeId(Long employeeId) {
        return employeeGoalRepository.calculateSumOfGoalsByEmployeeId(employeeId);
    }

}
