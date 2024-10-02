package gini.ginidashboardservice.repositories;


import gini.ginidashboardservice.models.Intervention;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long> {
    @Query(value = "SELECT i.description, sa.agent_name " +
            "FROM interactions i " +
            "JOIN sales_agents sa ON i.sales_agent_id = sa.sales_agent_id " +
            "WHERE i.employee_id = :employeeId " +
            "ORDER BY i.last_modified_at DESC",
            countQuery = "SELECT COUNT(*) " +
                    "FROM interactions i " +
                    "WHERE i.employee_id = :employeeId",
            nativeQuery = true)
    Page<Object[]> findInteractionsWithAgentNamesByEmployeeId(@Param("employeeId") Long employeeId, Pageable pageable);
}