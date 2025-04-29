package bits.current_savings_service.domain.response;

import bits.current_savings_service.domain.Entity.GroupInfo;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupInfoResponse {
    private Long id;

    private Long version;
    private Long assignedpoId;
    private Long branchInfoId;
    private Long closeReasonId;
    private Date closingDate;
    private Long createdBy;
    private Date dateCreated;
    private String demarcationArea;
    private Long domainStatusId;
    private Long groupCategoryId;
    private String groupCode;
    private Date groupCreationDate;
    private String groupName;
    private String groupReferenceNumber;
    private String scannedForm;
    private Long groupStatusId;
    private Boolean isTransferredGroup;
    private Date lastpoAssignedDate;
    private Date lastUpdated;
    private Long loanCollectionFrequencyId;
    private Date loanCollectionStartDate;
    private Long meetingDayId;
    private String meetingTime;
    private Date nextCollectionDate;
    private Date orientationDate;
    private Long projectInfoId;
    private Long savingsCollFrequencyId;
    private Date savingsCollectionStartDate;
    private String spotAddress;
    private Long updatedBy;
    private Long weekNumber;
    private Long serviceTerritoryId;
    private Long voCategoryId;
    private Long applicableGenderId;
    private String latitude;
    private String longitude;
    private String projectRefCode;
    private String coRefPin;
    private Timestamp oldNextCollectionDate;
    private Long assignedpoIdOld;
    private String isInactiveMemberMig;

    public static GroupInfoResponse convert(GroupInfo groupInfo) {

        return GroupInfoResponse.builder()
                .id(groupInfo.getId())
                .closingDate(groupInfo.getClosingDate())
                .createdBy(groupInfo.getCreatedBy())
                .dateCreated(groupInfo.getCreatedDate())
                .demarcationArea(groupInfo.getDemarcationArea())
                .groupCategoryId(groupInfo.getGroupCategoryId())
                .groupCode(groupInfo.getGroupCode())
                .groupCreationDate(groupInfo.getGroupCreationDate())
                .groupName(groupInfo.getGroupName())
                .groupReferenceNumber(groupInfo.getGroupReferenceNumber())
//                .scannedForm(groupInfo.getScannedForm())
                .groupStatusId(groupInfo.getGroupStatus().getId())
//                .lastpoAssignedDate(groupInfo.getLastpoAssignedDate())
                .lastUpdated(groupInfo.getLastModifiedDate())
                .loanCollectionStartDate(groupInfo.getLoanCollectionStartDate())
                .meetingTime(groupInfo.getMeetingTime())
                .nextCollectionDate(groupInfo.getNextCollectionDate())
                .orientationDate(groupInfo.getOrientationDate())
                .projectInfoId(groupInfo.getProjectInfo().getId())
                .savingsCollFrequencyId(groupInfo.getSavingsCollectionFrequency().getId())
                .savingsCollectionStartDate(groupInfo.getSavingsCollectionStartDate())
                .spotAddress(groupInfo.getSpotAddress())
                .updatedBy(groupInfo.getLastModifiedBy())
                .weekNumber(groupInfo.getWeekNumber())
                .serviceTerritoryId(groupInfo.getServiceTerritoryId())
                .voCategoryId(groupInfo.getVoCategoryId())
                .applicableGenderId(groupInfo.getApplicableGenderId())
                .latitude(groupInfo.getLatitude())
                .longitude(groupInfo.getLongitude())
                .build();
    }
}
