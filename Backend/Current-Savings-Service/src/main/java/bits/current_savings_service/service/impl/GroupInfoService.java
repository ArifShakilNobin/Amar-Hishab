package bits.current_savings_service.service.impl;

import bits.current_savings_service.common.logger.CurrentSavingsServiceLogger;
import bits.current_savings_service.common.utils.PageUtils;
import bits.current_savings_service.dto.requests.PaginationRequest;
import bits.current_savings_service.dto.response.GroupInfoResponse;
import bits.current_savings_service.dto.response.PaginationResponse;
import bits.current_savings_service.repository.GroupInfoRepository;
import bits.current_savings_service.service.BaseService;
import bits.current_savings_service.service.IGroupInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GroupInfoService extends BaseService implements IGroupInfoService {

    private final CurrentSavingsServiceLogger logger;
    private final GroupInfoRepository groupInfoRepository;

    @Override
    public PaginationResponse<GroupInfoResponse> getGroupInfo(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        try {
            // Map input parameters to PaginationRequest
            final PaginationRequest paginationRequest = PageUtils.mapToPaginationRequest(pageNumber, pageSize, sortBy, sortOrder);
            final Pageable pageable = PageUtils.getPageable(paginationRequest);

            Page<GroupInfoResponse> groupInfos = groupInfoRepository.getGroupInfos(pageable).map(GroupInfoResponse::convert);
            return groupInfos.getContent().isEmpty() ? PageUtils.mapToPaginationResponseDto(Page.empty(), paginationRequest) : PageUtils.mapToPaginationResponseDto(groupInfos, paginationRequest);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while getting group info: " + e.getMessage());
            return PageUtils.mapToPaginationResponseDto(Page.empty(), PageUtils.mapToPaginationRequest(pageNumber, pageSize, sortBy, sortOrder));

        }


    }
}
