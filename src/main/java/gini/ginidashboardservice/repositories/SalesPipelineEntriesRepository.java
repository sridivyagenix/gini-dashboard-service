package gini.ginidashboardservice.repositories;

import gini.ginidashboardservice.models.SalesPipelineEntries;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface SalesPipelineEntriesRepository extends R2dbcRepository<SalesPipelineEntries, Long> {
    Flux<SalesPipelineEntries> findByEmployeeIdAndCreatedDtBetweenAndStage(Long employeeId, Date startDate, Date endDate, String closedWon);

    Mono<Long> countDistinctPolicyNoByEmployeeIdAndCreatedDtBetweenAndStage(Long employeeId, Date startDate, Date endDate, String closedWon);

    Flux<SalesPipelineEntries> findByEmployeeIdAndCreatedDtBetweenAndOpportunityTypeInAndStageIn(Long employeeId, Date startDate, Date endDate, String[] opportunityType, String[] stages);
}
