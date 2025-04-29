package bits.current_savings_service.domain.Entity;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Enums.ProjectStatus;
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
@Table(name = "project_info")
public class ProjectInfo extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "proposal_id")
    private String proposalId;

    @ManyToOne
    @JoinColumn(name = "project_country_id")
    private Country projectCountry;

    @Column(name = "project_code")
    private String projectCode;

    @Column(name = "project_ref_code")
    private String projectRefCode;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "project_short_code")
    private String projectShortCode;

    @Column(name = "project_setup_date")
    @Temporal(TemporalType.DATE)
    private Date projectSetupDate;

    @Column(name = "project_effective_date")
    @Temporal(TemporalType.DATE)
    private Date projectEffectiveDate;

    @Column(name = "project_start_date")
    @Temporal(TemporalType.DATE)
    private Date projectStartDate;

    @Column(name = "project_end_date")
    @Temporal(TemporalType.DATE)
    private Date projectEndDate;

    @ManyToOne
    @JoinColumn(name = "domain_status_id")
    private DomainStatus domainStatus;

    @ManyToOne
    @JoinColumn(name = "program_info_id")
    private ProgramInfo programInfo;

    @Column(name = "book_closing")
    private boolean bookClosing;


    @Column(name = "parent_project_info_id")
    private Long parentProjectInfoId;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "is_independent")
    private Boolean isIndependent = false;

    @Column(name = "is_overhead")
    private Boolean isOverhead = false;

    @Column(name = "ho_type")
    private String hoType;

    @Column(name = "bo_type")
    private String boType;

    @Column(name = "mf_project_ref_code")
    private String mfProjectRefCode;

    @Column(name = "is_ngo_beuro")
    private Boolean isNgoBeuro;

    @Column(name = "beuro_from_date")
    @Temporal(TemporalType.DATE)
    private Date beuroFromDate;

    @Column(name = "beuro_to_date")
    @Temporal(TemporalType.DATE)
    private Date beuroToDate;

    @Column(name = "is_trendx_project")
    private Boolean isTrendxProject;

    @Column(name = "is_smart_collection")
    private Boolean isSmartCollection;

    @Column(name = "has_mf_operation", nullable = false)
    private boolean hasMfOperation;

    @Column(name = "project_status")
    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @Column(name = "start_month")
    private Integer startMonth;

    @Column(name = "end_month")
    private Integer endMonth;

    @Column(name = "mf_end_month")
    private Integer mfEndMonth;

    @Column(name = "has_fin_operation")
    private Boolean hasFinOperation;

    @Column(name = "source_of_fund_id")
    private Long sourceOfFundId;

    @Column(name = "remarks", columnDefinition = "text")
    private String remarks;

    @Column(name = "foreign_currency")
    private String foreignCurrency;

    @Column(name = "local_currency")
    private String localCurrency;

    @Column(name = "foreign_amount")
    private Long foreignAmount = 0L;

    @Column(name = "local_amount")
    private Long localAmount = 0L;

    @Column(name = "signing_date")
    @Temporal(TemporalType.DATE)
    private Date signingDate;
}
