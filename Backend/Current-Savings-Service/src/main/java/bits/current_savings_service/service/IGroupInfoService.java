package bits.current_savings_service.service;

import bits.current_savings_service.dto.response.GroupInfoResponse;
import bits.current_savings_service.dto.response.PaginationResponse;

public interface IGroupInfoService {

    PaginationResponse<GroupInfoResponse> getGroupInfo(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

}
