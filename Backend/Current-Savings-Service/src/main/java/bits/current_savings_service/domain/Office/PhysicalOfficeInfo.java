package bits.current_savings_service.domain.Office;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Entity.Country;
import bits.current_savings_service.domain.Entity.CountryOfficeHierarchy;
import bits.current_savings_service.domain.Enums.AreaType;
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
@Table(name = "physical_office_info")
public class PhysicalOfficeInfo extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "office_code", nullable = false, length = 15)
    private String officeCode;

    @Column(name = "office_ref_code")
    private String officeRefCode;

    @Column(name = "office_name")
    private String officeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_type_id")
    private OfficeType officeType;

    @Column(name = "area_type")
    @Enumerated(EnumType.STRING)
    private AreaType areaType;

    @Column(name = "setup_date")
    @Temporal(TemporalType.DATE)
    private Date setupDate;

    @Column(name = "effective_date")
    @Temporal(TemporalType.DATE)
    private Date effectiveDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registered_address_id")
    private OfficeAddress registeredAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_address_id")
    private OfficeAddress businessAddress;

    @Column(name = "office_status_id")
    private long officeStatusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_country_id")
    private Country officeCountry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_office_id")
    private PhysicalOfficeInfo parentOffice;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "is_hr_office")
    private Boolean isHrOffice = false;

    @Column(name = "is_mf_office")
    private Boolean isMfOffice = false;

    @Column(name = "is_dev_office")
    private Boolean isDevOffice = false;

    @Column(name = "is_upazila_accounts_office")
    private Boolean isUpazilaAccountsOffice = false;

    @Column(name = "is_indp")
    private Boolean isIndp = false;

    @Column(name = "verify_tb")
    private Boolean verifyTB;

    @Column(name = "verify_portfolio")
    private Boolean verifyPortfolio;

    @Column(name = "verify_savings")
    private Boolean verifySavings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_hierarchy_id")
    private CountryOfficeHierarchy officeHierarchy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporting_to_id")
    private PhysicalOfficeInfo reportingTo;


    @Column(name = "mf_branch_id")
    private String mfBranchId;

    @Column(name = "mf_ref_code")
    private String mfRefCode;

    @Column(name = "dev_ref_code")
    private String devRefCode;

    @Column(name = "has_operation", nullable = false)
    private Boolean hasOperation = false;

    @Column(name = "bkash_wallet_no")
    private String bkashWalletNo;

    @Column(name = "operation_category")
    private String operationCategory;

    @Column(name = "parent_project_id")
    private Long parentProjectId;
}
