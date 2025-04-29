package bits.current_savings_service.domain.Member;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Employee.EmployeeCoreInfo;
import bits.current_savings_service.domain.Entity.*;
import bits.current_savings_service.domain.Nominee.NomineeInfo;
import bits.current_savings_service.domain.Office.PhysicalOfficeInfo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member_info")
public class MemberInfo extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "branch_info_id")
    private PhysicalOfficeInfo branchInfo;

    @ManyToOne
    @JoinColumn(name = "assignedpo_id")
    private EmployeeCoreInfo assignedPO;

    @ManyToOne
    @JoinColumn(name = "project_info_id", nullable = false)
    private ProjectInfo projectInfo;

    @ManyToOne
    @JoinColumn(name = "group_info_id")
    private GroupInfo groupInfo;

    @Column(name = "member_no")
    private String memberNo;

    @Column(name = "reference_no")
    private String referenceNo;

    @Column(name = "group_ref_no")
    private String groupRefNo;

    @Column(name = "member_name", nullable = false, length = 50)
    private String memberName;

    @Column(name = "f_name")
    private String fName;

    @Column(name = "m_name")
    private String mName;

    @Column(name = "l_name")
    private String lName;

    @Column(name = "application_date")
    private Date applicationDate;

    @Column(name = "survey_report_no")
    private String surveyReportNo;

    @Column(name = "membership_date")
    private Date membershipDate;

    @Column(name = "lastpoassigned_date")
    private Date lastPOAssignedDate;

    @ManyToOne
    @JoinColumn(name = "member_status_id", nullable = false)
    private MemberStatus memberStatus;

    @Column(name = "expired_date")
    private Date expiredDate;

    @Column(name = "closing_date")
    private Date closingDate;

    @ManyToOne
    @JoinColumn(name = "domain_status_id")
    private DomainStatus domainStatus;

    @Column(name = "is_transferred_member")
    private boolean isTransferredMember;

    @ManyToOne
    @JoinColumn(name = "close_reason_id")
    private CloseReason closeReason;

    @Column(name = "transfer_transaction_ref_no")
    private String transferTransactionRefNo;

    @Column(name = "loan_cycle_no")
    private long loanCycleNo = 0;

    @Column(name = "member_custom_field")
    private String memberCustomField;

    @OneToOne
    @JoinColumn(name = "personal_info_id")
    private PersonalInfo personalInfo;

    @OneToOne
    @JoinColumn(name = "guarantor_info_id")
    private GuarantorInfo guarantorInfo;

    @OneToOne
    @JoinColumn(name = "family_info_id")
    private FamilyInfo familyInfo;

    @OneToOne
    @JoinColumn(name = "contact_info_id")
    private ContactInfo contactInfo;

    @OneToOne
    @JoinColumn(name = "signature_id")
    private Signature signature;

    @OneToOne
    @JoinColumn(name = "documents_id")
    private MembershipDocument documents;

    @Column(name = "member_classification_id")
    private long memberClassificationId;

    @Column(name = "referred_by")
    private String referredBy;

    @Column(name = "passbook_no")
    private String passbookNo;

    @Column(name = "tin_number", length = 12)
    private String tinNumber;

    @Column(name = "academic_qualification_id")
    private Long academicQualificationId;

    @Column(name = "bank_id")
    private Long bankId;

    @Column(name = "bank_branch_id")
    private Long bankBranchId;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "routing_number")
    private String routingNumber;

    @Column(name = "incident_status")
    private int incidentStatus;

    @Column(name = "buffer_id")
    private String bufferId;

    @Column(name = "api_data_source_id")
    private Integer apiDataSourceId;


    @Column(name = "uuid_no")
    private Long uuidNo;

    @OneToMany(mappedBy = "memberInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NomineeInfo> nNomineeInfos;

    @OneToMany(mappedBy = "memberInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PassbookInfo> nPassbookInfos;

    @Transient
    private Map<String, Object> transientFields;

}
