package gini.ginidashboardservice.repositories;

import gini.ginidashboardservice.models.Intervention;
import gini.ginidashboardservice.models.SalesAgent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesAgentRepository extends JpaRepository<SalesAgent, Long> {
    List<Intervention> findBySalesAgentId(Long salesAgentId);
}