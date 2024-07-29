package gini.ginidashboardservice.repositories;

import gini.ginidashboardservice.dto.StageSummary;
import gini.ginidashboardservice.models.SalesPipelineEntries;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

public interface SalesPipelineEntriesRepository extends ReactiveCrudRepository<SalesPipelineEntries, Long> {
    Flux<SalesPipelineEntries> findByEmployeeIdAndCreatedDtBetweenAndStage(Long employeeId, Date startDate, Date endDate, String closedWon);

    Mono<Long> countDistinctPolicyNoByEmployeeIdAndCreatedDtBetweenAndStage(Long employeeId, Date startDate, Date endDate, String closedWon);

    Flux<SalesPipelineEntries> findByEmployeeIdAndCreatedDtBetweenAndOpportunityTypeInAndStageIn(Long employeeId, Date startDate, Date endDate, String[] opportunityType, String[] stages);

    @Query("SELECT stage, COUNT(policy_no) AS policy_count, SUM(target_premium_amount) AS premium_sum " +
            "FROM sales_pipeline_entries " +
            "WHERE employee_id = :employeeId AND YEAR(created_dt) = YEAR(CURRENT_DATE) " +
            "GROUP BY stage")
    Flux<StageSummary> findPoliciesCountAndPremiumSumByStageForEmployee(Long employeeId);
}
