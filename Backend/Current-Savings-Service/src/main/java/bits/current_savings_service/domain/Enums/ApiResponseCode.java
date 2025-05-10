package bits.current_savings_service.domain.Enums;

import bits.current_savings_service.dto.response.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum ApiResponseCode {

    OPERATION_SUCCESSFUL(HttpStatus.OK.value()),
    AlREADY_EXIST(HttpStatus.BAD_REQUEST.value()),
    INTER_SERVICE_COMMUNICATION_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value()),
    DB_OPERATION_FAILED(HttpStatus.GATEWAY_TIMEOUT.value()),
    REQUEST_PROCESSING_FAILED(HttpStatus.SERVICE_UNAVAILABLE.value()),
    INVALID_REQUEST_DATA(HttpStatus.BAD_REQUEST.value()),
    RECORD_NOT_FOUND(HttpStatus.NOT_FOUND.value()),
    ALREADY_EXIST(HttpStatus.FORBIDDEN.value()),
    VALIDATION_FAILED(HttpStatus.BAD_REQUEST.value()),
    OPERATION_FAILED(HttpStatus.BAD_REQUEST.value());

    private final int responseCode;

    public static boolean isOperationSuccessful(ApiResponse<?> apiResponse) {
        return Objects.nonNull(apiResponse)
                && apiResponse.getResponseCode() == OPERATION_SUCCESSFUL.getResponseCode();
    }

    public static boolean isNotOperationSuccessful(ApiResponse<?> apiResponse) {
        return !isOperationSuccessful(apiResponse);
    }
}