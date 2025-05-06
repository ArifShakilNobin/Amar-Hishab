package bits.current_savings_service.api.common;

import bits.current_savings_service.api.BaseResource;
import bits.current_savings_service.common.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppUtils.BASE_URL + "/vo")
public class VoController extends BaseResource {
//    private final IGroupInfoService groupInfoService;
//
//    @GetMapping("/group-info")
//    public ApiResponse<PaginationResponse<GroupInfoResponse>> getAllGroupInfos(
//            @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
//            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
//            @RequestParam(required = false, defaultValue = "id") String sortBy,
//            @RequestParam(required = false, defaultValue = "desc") String sortOrder) {
//
//        PaginationResponse<GroupInfoResponse> groupInfo = groupInfoService.getGroupInfo(pageNumber, pageSize, sortBy, sortOrder);
//
////        logger.error("Group Info: " + groupInfo.toString());
//    }


}
