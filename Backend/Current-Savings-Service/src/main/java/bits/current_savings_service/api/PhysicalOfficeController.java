package bits.current_savings_service.api;

import bits.current_savings_service.common.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppUtils.BASE_URL + "/physical-office")
public class PhysicalOfficeController extends BaseResource {
//
//    private final IPhysicalOfficeInfoService iphysicalOfficeInfoService;
//
////    @GetMapping()
////    public ApiResponse<List<PhysicalOfficeInfo>> getAllPhysicalOffice(){
////        List<PhysicalOfficeInfo> physicalOfficeInfos = iphysicalOfficeInfoService.getAllPhysicalOffice();
////
////    }
//
//    @GetMapping()
//    public ResponseEntity<?> getAllGroupInfos(
//            @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
//            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
//            @RequestParam(required = false, defaultValue = "id") String sortBy,
//            @RequestParam(required = false, defaultValue = "desc") String sortOrder) {
//
//        PaginationResponse<PhysicalOfficeInfo> physicalOfficeInfos = iphysicalOfficeInfoService.getAllOfficeInfos(pageNumber, pageSize, sortBy, sortOrder);
//        if(Objects.isNull(physicalOfficeInfos)){
//            ResponseEntity.noContent();
//        }
//        return ResponseEntity.ok(physicalOfficeInfos);
////        logger.error("Group Info: " + groupInfo.toString());
//
//    }
}
