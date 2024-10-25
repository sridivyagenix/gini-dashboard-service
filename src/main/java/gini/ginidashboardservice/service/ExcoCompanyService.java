package gini.ginidashboardservice.service;


import gini.ginidashboardservice.models.ExcoCompany;
import gini.ginidashboardservice.repositories.ExcoCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class ExcoCompanyService {

    @Autowired
    private ExcoCompanyRepository excoCompanyRepository;

    public Optional<ExcoCompany> getCompanyByTickerAndReportDate(String ticker, int fiscalYr) {
        return excoCompanyRepository.findByTickerAndFiscalYr(ticker, fiscalYr);
    }
}
