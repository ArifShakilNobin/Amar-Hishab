package bits.current_savings_service.api.common;

import bits.current_savings_service.api.BaseResource;
import bits.current_savings_service.common.utils.AppUtils;
import bits.current_savings_service.common.utils.ResponseUtils;
import bits.current_savings_service.domain.Enums.ResponseMessage;
import bits.current_savings_service.domain.Office.PhysicalOfficeInfo;
import bits.current_savings_service.dto.response.ApiResponse;
import bits.current_savings_service.dto.response.PaginationResponse;
import bits.current_savings_service.service.IPhysicalOfficeInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppUtils.BASE_URL + "/physical-office")
@Tag(name = "Physical Office", description = "Physical Office")
public class PhysicalOfficeController extends BaseResource {

    private final IPhysicalOfficeInfoService iphysicalOfficeInfoService;

    @Operation(summary = "Create Physical Office", description = "Create Physical Office")
    @PostMapping
    public ApiResponse<?> createPhysicalOfficeInfo(@RequestBody PhysicalOfficeInfo physicalOfficeInfo) {
        return iphysicalOfficeInfoService.createOfficeInfo(physicalOfficeInfo);
    }

    @GetMapping()
    public ApiResponse<?> getAllGroupInfos(
            @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(required = false, defaultValue = "id") String sortBy,
            @RequestParam(required = false, defaultValue = "desc") String sortOrder) {

        PaginationResponse<PhysicalOfficeInfo> physicalOfficeInfos = iphysicalOfficeInfoService.getAllOfficeInfos(pageNumber, pageSize, sortBy, sortOrder);

        if (Objects.isNull(physicalOfficeInfos)) {
            return ResponseUtils.createResponseObject(ResponseMessage.RECORD_NOT_FOUND, null);
        }
        return ResponseUtils.createResponseObject(ResponseMessage.OPERATION_SUCCESSFUL, physicalOfficeInfos);

    }
}
