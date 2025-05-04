package bits.current_savings_service.service.impl;

import bits.current_savings_service.common.logger.CurrentSavingsServiceLogger;
import bits.current_savings_service.common.utils.PageUtils;
import bits.current_savings_service.domain.Office.PhysicalOfficeInfo;
import bits.current_savings_service.dto.requests.PaginationRequest;
import bits.current_savings_service.dto.response.PaginationResponse;
import bits.current_savings_service.repository.PhysicalOfficeRepository;
import bits.current_savings_service.service.IPhysicalOfficeInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhysicalOfficeInfoService implements IPhysicalOfficeInfoService {
    private final CurrentSavingsServiceLogger logger;
    private final PhysicalOfficeRepository physicalOfficeRepository;

    @Override
    public List<PhysicalOfficeInfo> getAllPhysicalOffice() {
        return physicalOfficeRepository.findAll();
    }


    @Override
    public PaginationResponse<PhysicalOfficeInfo> getAllOfficeInfos(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        try {
            // Map input parameters to PaginationRequest
            final PaginationRequest paginationRequest = PageUtils.mapToPaginationRequest(pageNumber, pageSize, sortBy, sortOrder);
            final Pageable pageable = PageUtils.getPageable(paginationRequest);

            Page<PhysicalOfficeInfo> physicalOfficeInfos = physicalOfficeRepository.findAll(pageable);
            return physicalOfficeInfos.getContent().isEmpty() ? PageUtils.mapToPaginationResponseDto(Page.empty(), paginationRequest) : PageUtils.mapToPaginationResponseDto(physicalOfficeInfos, paginationRequest);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while getting group info: " + e.getMessage());
            return PageUtils.mapToPaginationResponseDto(Page.empty(), PageUtils.mapToPaginationRequest(pageNumber, pageSize, sortBy, sortOrder));

        }


    }
}
