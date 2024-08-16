package gini.ginidashboardservice.repositories;

import gini.ginidashboardservice.models.PolicyRetentionRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRetentionRiskRepository extends JpaRepository<PolicyRetentionRisk, Long> {

    List<PolicyRetentionRisk> findAllByOrderBySurrenderProbablityPctDesc();
}