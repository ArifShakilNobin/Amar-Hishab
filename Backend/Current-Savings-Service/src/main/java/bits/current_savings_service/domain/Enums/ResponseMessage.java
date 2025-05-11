package bits.current_savings_service.domain.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ResponseMessage {
    OPERATION_SUCCESSFUL(ApiResponseCode.OPERATION_SUCCESSFUL.getResponseCode(), "Operation is completed successfully."),
    ALREADY_REQUEST_PENDING(ApiResponseCode.AlREADY_EXIST.getResponseCode(), "Already request pending."),
    INTER_SERVICE_COMMUNICATION_ERROR(ApiResponseCode.INTER_SERVICE_COMMUNICATION_ERROR.getResponseCode(), "Inter service communication error."),
    DATABASE_EXCEPTION(ApiResponseCode.DB_OPERATION_FAILED.getResponseCode(), "Database operation failed."),
    INTERNAL_SERVICE_EXCEPTION(ApiResponseCode.REQUEST_PROCESSING_FAILED.getResponseCode(), "Internal service exception."),
    INVALID_REQUEST_DATA(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "Invalid request data."),
    RECORD_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "Record not found."),
    VALIDATION_FAILED(ApiResponseCode.VALIDATION_FAILED.getResponseCode(), "Validation failed."),
    OPERATION_FAILED(ApiResponseCode.OPERATION_FAILED.getResponseCode(), "Operation failed.");

    private final int responseCode;
    private final String responseMessage;

}
