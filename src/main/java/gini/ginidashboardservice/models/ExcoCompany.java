package gini.ginidashboardservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "exco_companies")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExcoCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exco_company_id")
    private Long excoCompanyId;

    @Column(name = "ticker", nullable = false, length = 20)
    private String ticker;

    @Column(name = "fiscal_yr", nullable = false)
    private Integer fiscalYr;

    @Column(name = "publish_dt")
    private Date publishDt;

    @Column(name = "company_name_x", length = 100)
    private String companyNameX;

    @Column(name = "industry", length = 50)
    private String industry;

    @Column(name = "sector", length = 50)
    private String sector;

    @Column(name = "market_cap")
    private BigDecimal marketCap;

    @Column(name = "revenue_fy_2023")
    private BigDecimal revenueFy2023;

    @Column(name = "eps", precision = 5, scale = 2)
    private BigDecimal eps;

    @Column(name = "outstanding_shares_fully_diluted")
    private Long outstandingSharesFullyDiluted;

    @Column(name = "pe_ratio")
    private Double peRatio;

    @Column(name = "roe_pct")
    private Double roePct;

    @Column(name = "free_cash_flow", precision = 18, scale = 2)
    private BigDecimal freeCashFlow;

    @Column(name = "dividend_yield_pct")
    private Float dividendYieldPct;

    @Column(name = "one_yr_stock_performance_pct")
    private Float oneYrStockPerformancePct;

    @Column(name = "two_yr_stock_performance_pct")
    private Float twoYrStockPerformancePct;

    @Column(name = "one_yr_revenue_growth_pct")
    private Float oneYrRevenueGrowthPct;

    @Column(name = "two_yr_revenue_growth_pct")
    private Float twoYrRevenueGrowthPct;

    @Column(name = "profit_margin_pct")
    private Float profitMarginPct;

    @Column(name = "debt_to_equity_ratio")
    private Double debtToEquityRatio;

    @Column(name = "company_name_y", length = 100)
    private String companyNameY;

    @Column(name = "salary_usd", precision = 18, scale = 2)
    private BigDecimal salaryUsd;

    @Column(name = "bonus_usd", precision = 18, scale = 2)
    private BigDecimal bonusUsd;

    @Column(name = "stock_awards_usd", precision = 18, scale = 2)
    private BigDecimal stockAwardsUsd;

    @Column(name = "non_equity_incentive_plan_comp_usd", precision = 10, scale = 2)
    private BigDecimal nonEquityIncentivePlanCompUsd;

    @Column(name = "all_other_comp_usd", precision = 18, scale = 2)
    private BigDecimal allOtherCompUsd;

    @Column(name = "total_ceo_comp_check", precision = 18, scale = 2)
    private BigDecimal totalCeoCompCheck;

    @Column(name = "ceo_total_comp", precision = 18, scale = 2)
    private BigDecimal ceoTotalComp;

    @Column(name = "ceo_total_comp_2023", precision = 18, scale = 2)
    private BigDecimal ceoTotalComp2023;

    @Column(name = "median_ee_comp", precision = 18, scale = 2)
    private BigDecimal medianEeComp;

    @Column(name = "ceo_pay_ratio")
    private Double ceoPayRatio;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "last_modified_at", nullable = false)
    private Timestamp lastModifiedAt;
}