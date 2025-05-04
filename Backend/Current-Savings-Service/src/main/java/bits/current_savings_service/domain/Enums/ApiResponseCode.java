package bits.current_savings_service.domain.Enums;

import bits.current_savings_service.domain.Common.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum ApiResponseCode {

    OPERATION_SUCCESSFUL("OS100000"),
    AlREADY_EXIST("AE00185"),
    INTER_SERVICE_COMMUNICATION_ERROR("ISCE000111"),
    DB_OPERATION_FAILED("DBOF000112"),
    REQUEST_PROCESSING_FAILED("RPF000113"),
    INVALID_REQUEST_DATA("E000102"),
    RECORD_NOT_FOUND("E000103"),
    ALREADY_EXIST("AE00185"),
    VALIDATION_FAILED("VF000114"),

    ;

    private String responseCode;

    public static boolean isOperationSuccessful(ApiResponse apiResponse) {
        return Objects.nonNull(apiResponse) && apiResponse.getResponseCode().equals(ApiResponseCode.OPERATION_SUCCESSFUL.getResponseCode());
    }

    public static boolean isNotOperationSuccessful(ApiResponse apiResponse) {
        return !isOperationSuccessful(apiResponse);
    }

}
