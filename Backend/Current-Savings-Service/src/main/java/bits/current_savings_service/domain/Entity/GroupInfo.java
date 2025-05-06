package bits.current_savings_service.domain.Entity;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Employee.EmployeeCoreInfo;
import bits.current_savings_service.domain.Office.PhysicalOfficeInfo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "group_infos")
public class GroupInfo extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "group_code")
    private String groupCode;

    @Column(name = "group_name")
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "assignedpo_id", nullable = false)
    private EmployeeCoreInfo assignedPO;

    @Column(name = "orientation_date")
    private Date orientationDate;

    @Column(name = "group_creation_date")
    private Date groupCreationDate;

    @Column(name = "lastpoassigned_date")
    private Date lastPOAssignedDate;

    @Column(name = "group_reference_number", length = 25)
    private String groupReferenceNumber;

    @Column(name = "spot_address", length = 255)
    private String spotAddress;

    @ManyToOne
    @JoinColumn(name = "group_status_id", nullable = false)
    private GroupStatus groupStatus;

    @ManyToOne
    @JoinColumn(name = "domain_status_id", nullable = false)
    private DomainStatus domainStatus;

    @ManyToOne
    @JoinColumn(name = "close_reason_id")
    private GroupCloseReason closeReason;

    @Column(name = "closing_date")
    private Date closingDate;

    @ManyToOne
    @JoinColumn(name = "meeting_day_id", nullable = false)
    private Day meetingDay;

    @Column(name = "meeting_time")
    private String meetingTime = "10:00 AM";

    @Column(name = "demarcation_area", length = 255)
    private String demarcationArea;

    @Column(name = "week_number")
    private long weekNumber;

    @ManyToOne
    @JoinColumn(name = "loan_collection_frequency_id", nullable = false)
    private CollectionFrequency loanCollectionFrequency;

    @Column(name = "loan_collection_start_date")
    private Date loanCollectionStartDate;

    @ManyToOne
    @JoinColumn(name = "savings_collection_frequency_id", nullable = false)
    private CollectionFrequency savingsCollectionFrequency;

    @Column(name = "savings_collection_start_date")
    private Date savingsCollectionStartDate;

    @Column(name = "next_collection_date")
    private Date nextCollectionDate;

    @ManyToOne
    @JoinColumn(name = "branch_info_id")
    private PhysicalOfficeInfo branchInfo;

    @ManyToOne
    @JoinColumn(name = "project_info_id", nullable = false)
    private ProjectInfo projectInfo;

    @Column(name = "scanned_form")
    private String groupScannedForm;

    @Column(name = "is_transferred_group")
    private boolean isTransferredGroup;

    @Column(name = "group_category_id")
    private long groupCategoryId = 1;  // Default value

    @Column(name = "vo_category_id")
    private Long voCategoryId;

    @Column(name = "service_territory_id")
    private Long serviceTerritoryId;

    @Column(name = "applicable_gender_id")
    private long applicableGenderId;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;


}
