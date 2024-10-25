package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.models.ExcoCompany;
import gini.ginidashboardservice.service.ExcoCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ExcoCompanyController {

    @Autowired
    private ExcoCompanyService excoCompanyService;

    @GetMapping("/search")
    public ResponseEntity<ExcoCompany> getCompany(
            @RequestParam("ticker") String ticker,
            @RequestParam("fiscal_yr") int fiscalYr) {

        Optional<ExcoCompany> excoCompany = excoCompanyService.getCompanyByTickerAndReportDate(ticker, fiscalYr);

        if (excoCompany.isPresent()) {
            ExcoCompany company = excoCompany.get();
            // Log the result for debugging
            System.out.println("Company found: " + company);
            return ResponseEntity.ok(company);
        } else {
            System.out.println("Company not found for ticker: " + ticker + " and fiscal year: " + fiscalYr);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
