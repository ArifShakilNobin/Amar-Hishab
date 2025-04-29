package bits.current_savings_service.domain.Employee;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Entity.*;
import bits.current_savings_service.domain.Enums.ApprovalStatus;
import bits.current_savings_service.domain.Office.PhysicalOfficeInfo;
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
@Table(name = "employee_core_info")
public class EmployeeCoreInfo extends Audit implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "home_country_id", nullable = false)
    private Long homeCountryId;

    @Column(name = "pin_no", nullable = false)
    private String pinNo;

    @Column(name = "ref_pin")
    private String refPin;

    @Column(name = "joining_date")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    @ManyToOne
    @JoinColumn(name = "salutation_id")
    private Salutation salutation;

    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "nick_name", length = 50)
    private String nickName;

    @Column(name = "gender_id")
    private Long genderId;

    @Column(name = "employee_dob")
    @Temporal(TemporalType.DATE)
    private Date employeeDob;

    @Column(name = "domain_status_id")
    private Long domainStatusId;

    @ManyToOne
    @JoinColumn(name = "employee_status_id", nullable = false)
    private EmployeeStatus employeeStatus;

    @Column(name = "provision_end_date")
    @Temporal(TemporalType.DATE)
    private Date provisionEndDate;

    @ManyToOne
    @JoinColumn(name = "cur_job_status_id", nullable = false)
    private EmployeeJobStatus curJobStatus;

    @Column(name = "is_on_deputation")
    private Boolean isOnDeputation = false;

    @Column(name = "deputation_end_date")
    @Temporal(TemporalType.DATE)
    private Date deputationEndDate;

    @Column(name = "cur_job_start_date")
    @Temporal(TemporalType.DATE)
    private Date curJobStartDate;

    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    @Column(name = "approval_status")
    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

    @Column(name = "approval_date")
    @Temporal(TemporalType.DATE)
    private Date approvalDate;

    @Column(name = "is_issued_letter")
    private Boolean isIssuedLetter = false;

    @Column(name = "is_issued_retire_letter")
    private Boolean isIssuedRetireLetter = false;

    @Column(name = "employee_level_id")
    private Long employeeLevelId;

    @Column(name = "emp_category_id")
    private Long empCategoryId;

    @Column(name = "e_designation_id")
    private Long eDesignationId;

    @Column(name = "f_designation_id")
    private Long fDesignationId;

    @Column(name = "office_country_id")
    private Long officeCountryId;

    @ManyToOne
    @JoinColumn(name = "office_info_id")
    private PhysicalOfficeInfo officeInfo;

    @ManyToOne
    @JoinColumn(name = "program_type_id")
    private ProgramType programType;

    @ManyToOne
    @JoinColumn(name = "core_project_id")
    private ProjectInfo coreProject;

    @ManyToOne
    @JoinColumn(name = "core_program_id")
    private ProgramInfo coreProgram;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private OrganizationDepartment department;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private EmployeeCoreInfo supervisor;

    @Column(name = "assigned_date")
    @Temporal(TemporalType.DATE)
    private Date assignedDate;

    @Column(name = "notice_period")
    private Long noticePeriod;

    @Column(name = "probation_notice_period")
    private Long probationNoticePeriod;

    @Column(name = "working_hour")
    private Long workingHour = 40L;

    @Column(name = "working_day_in_week")
    private Long workingDayInWeek;

    @Column(name = "nominee_form")
    private Long nomineeForm;

    @Column(name = "is_expatriate")
    private boolean isExpatriate = false;

    @Column(name = "country_level_id")
    private Long countryLevelId;

    @Column(name = "recruitment_country_id")
    private Long recruitmentCountryId;

    @Column(name = "cur_country_join_date")
    @Temporal(TemporalType.DATE)
    private Date curCountryJoinDate;

    @Column(name = "cur_office_join_date")
    @Temporal(TemporalType.DATE)
    private Date curOfficeJoinDate;

    @Column(name = "contract_start_date")
    @Temporal(TemporalType.DATE)
    private Date contractStartDate;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "unit_id")
    private Long unitId;

    @Column(name = "position_id")
    private String positionId;

    @Column(name = "roll_no")
    private String rollNo;

    @Column(name = "recruit_req_no")
    private String recruitReqNo;

    @Column(name = "previous_emp_core_info_id")
    private Long previousEmpCoreInfoId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "national_id_no")
    private String nationalIdNo;

    @Column(name = "smart_nid_no")
    private String smartNIDNo;

    @Column(name = "slab_id")
    private Long slabId;

    @Column(name = "pay_group_id")
    private Long payGroupId;

    @Column(name = "currency_name")
    private String currencyName;

    @Column(name = "is_increment")
    private Boolean isIncrement;

    @Column(name = "is_promotion")
    private Boolean isPromotion;

    @Column(name = "is_leave")
    private Boolean isLeave;

    @Column(name = "is_attendance")
    private Boolean isAttendance;

    @Column(name = "joining_date_as_pa")
    @Temporal(TemporalType.DATE)
    private Date joiningDateASPA;

    @Column(name = "religion_id")
    private Long religionId;

    @Column(name = "is_receive")
    private Boolean isReceive = true;

    @Column(name = "is_post_ref_required")
    private Boolean isPostRefRequired = false;

    @Column(name = "is_post_ref_completed")
    private Boolean isPostRefCompleted = false;

    @Column(name = "is_back_check_completed")
    private Boolean isBackCheckCompleted = false;

    @Column(name = "organogram")
    private Long organogram;

    @Column(name = "position")
    private Long position;

    @Column(name = "ref_erecruit_id")
    private String refErecruitId;

    @Column(name = "tin_type_id")
    private Long tinTypeId;

    @Column(name = "tin_number")
    private String tinNumber;

}
