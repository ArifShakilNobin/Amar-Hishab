package bits.current_savings_service.service;

import bits.current_savings_service.domain.Office.PhysicalOfficeInfo;
import bits.current_savings_service.dto.response.PaginationResponse;

import java.util.List;

public interface IPhysicalOfficeInfoService {

    List<PhysicalOfficeInfo> getAllPhysicalOffice();

    PaginationResponse<PhysicalOfficeInfo> getAllOfficeInfos(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

}
