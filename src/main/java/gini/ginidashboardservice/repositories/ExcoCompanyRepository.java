package gini.ginidashboardservice.repositories;

import gini.ginidashboardservice.models.ExcoCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.Optional;

public interface ExcoCompanyRepository extends JpaRepository<ExcoCompany, Long> {
    Optional<ExcoCompany> findByTickerAndFiscalYr(String ticker, int reportDate);
}
