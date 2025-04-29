package bits.current_savings_service.domain.Account;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Entity.*;
import bits.current_savings_service.domain.Member.MemberInfo;
import bits.current_savings_service.domain.Product.SavingsProduct;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "savings_account")
public class SavingsAccount extends Audit implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "account_name")
    private String accountName;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private SavingsAccountType accountType;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "closing_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closingDate;

    @Column(name = "initial_deposit")
    private double initialDeposit;

    @Column(name = "installment_amount")
    private double installmentAmount;

    @Column(name = "office_info_id")
    private Long officeInfoId;

    @Column(name = "group_info_id")
    private Long groupInfoId;

    @ManyToOne
    @JoinColumn(name = "project_info_id")
    private ProjectInfo projectInfo;

    @ManyToOne
    @JoinColumn(name = "savings_product_id")
    private SavingsProduct savingsProduct;

    @Column(name = "interest_rate")
    private double interestRate;

    @ManyToOne
    @JoinColumn(name = "calculation_frequency_id")
    private InterestCalculationFrequency calculationFrequency;

    @ManyToOne
    @JoinColumn(name = "provision_frequency_id")
    private InterestProvisionFrequency provisionFrequency;

    @ManyToOne
    @JoinColumn(name = "calculation_method_id")
    private InterestCalculationMethod calculationMethod;

    @ManyToOne
    @JoinColumn(name = "credit_frequency_id")
    private InterestCreditFrequency creditFrequency;

    @ManyToOne
    @JoinColumn(name = "account_status_id")
    private SavingsAccountStatus accountStatus;

    @ManyToOne
    @JoinColumn(name = "portfolio_status_id")
    private SavingsPortfolioStatus portfolioStatus;

    @ManyToOne
    @JoinColumn(name = "domain_status_id")
    private DomainStatus domainStatus;

    @Column(name = "savings_balance")
    private double savingsBalance;

    @Column(name = "provisioned_interest")
    private double provisionedInterest;

    @Column(name = "calculated_interest")
    private double calculatedInterest;

    @Column(name = "is_transferred_savings")
    private boolean isTransferredSavings;

    @Column(name = "has_matched_fund")
    private boolean hasMatchedFund;

    @Column(name = "match_fund_max_amount")
    private Double matchFundMaxAmount;

    @Column(name = "match_ratio")
    private Double matchRatio;

    @Column(name = "match_fund_expired_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date matchFundExpiredDate;

    @Column(name = "cohort_mapping_id")
    private Long cohortMappingId;

    @Column(name = "next_collection_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextCollectionDate;

    @Column(name = "last_transferred_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTransferredDate;

    @Column(name = "current_savings_account_type")
    private Integer currentSavingsAccountType;

    @Column(name = "current_account_mobile")
    private String currentAccountMobile;

    @Column(name = "otp_send_type")
    private Integer otpSendType;

    @Column(name = "last_interest_calculation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastInterestCalculationDate;

    @Column(name = "is_inter_member_transferred")
    private Boolean isInterMemberTransferred;

    @Column(name = "uid_cycle_no")
    private int uidCycleNo = 0;

    @Column(name = "uid_status")
    private int uidStatus = 1; // 1: Active 2: Closed

    @ManyToOne
    @JoinColumn(name = "member_info_id")
    private MemberInfo memberInfo;
}