package bits.current_savings_service.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseMessage {

    OPERATION_SUCCESSFUL(ApiResponseCode.OPERATION_SUCCESSFUL.getResponseCode(), "operation.success"),

    ALREADY_REQUEST_PENDING(ApiResponseCode.AlREADY_EXIST.getResponseCode(), "already.request.pending"),
    INTER_SERVICE_COMMUNICATION_ERROR(ApiResponseCode.INTER_SERVICE_COMMUNICATION_ERROR.getResponseCode(), "inter.service.communication.exception"),
    DATABASE_EXCEPTION(ApiResponseCode.DB_OPERATION_FAILED.getResponseCode(), "database.exception"),
    INTERNAL_SERVICE_EXCEPTION(ApiResponseCode.REQUEST_PROCESSING_FAILED.getResponseCode(), "internal.service.exception"),
    INVALID_REQUEST_DATA(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "invalid.request.data"),
    RECORD_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "record.not.found"),

    ;

    private final String responseCode;
    private final String responseMessage;

}
