package bits.current_savings_service.common.utils;


import bits.current_savings_service.dto.response.ApiResponse;
import bits.current_savings_service.domain.Enums.ResponseMessage;

import java.time.LocalDateTime;
import java.util.Objects;

public class ResponseUtils {

    public static <T> ApiResponse<T> createResponseObject(String message) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setResponseCode(ResponseMessage.OPERATION_SUCCESSFUL.getResponseCode());
        apiResponse.setResponseMessage(message);
        apiResponse.setTimestamp(LocalDateTime.now());
        return apiResponse;
    }

    public static <T> ApiResponse<T> createResponseObject(String message, T data) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setResponseCode(ResponseMessage.OPERATION_SUCCESSFUL.getResponseCode());
        apiResponse.setResponseMessage(message);
        apiResponse.setData(data);
        apiResponse.setTimestamp(LocalDateTime.now());
        return apiResponse;
    }

    public static <T> ApiResponse<T> createResponseObject(ResponseMessage responseMessage, T data) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setResponseCode(responseMessage.getResponseCode());
        apiResponse.setResponseMessage(responseMessage.getResponseMessage());
        apiResponse.setData(data);
        apiResponse.setTimestamp(LocalDateTime.now());
        return apiResponse;
    }

    public static <T> ApiResponse<T> createResponseObject(ResponseMessage responseMessage) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setResponseCode(responseMessage.getResponseCode());
        apiResponse.setResponseMessage(responseMessage.getResponseMessage());
        apiResponse.setTimestamp(LocalDateTime.now());
        return apiResponse;
    }

    public static <T> ApiResponse<T> createResponseObject(String code, String message) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setResponseCode(code);
        apiResponse.setResponseMessage(message);
        apiResponse.setTimestamp(LocalDateTime.now());
        return apiResponse;
    }

    public static <T> ApiResponse<T> createSuccessfulResponse() {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setResponseCode(ResponseMessage.OPERATION_SUCCESSFUL.getResponseCode());
        apiResponse.setResponseMessage("Operation is completed successfully.");
        return apiResponse;
    }

    public static <T> ApiResponse<T> copyResponse(ApiResponse<T> apiResponse, ApiResponse<?> sourceResponse, Class<T> clazz) {
        apiResponse = Objects.isNull(apiResponse) ? new ApiResponse<>() : apiResponse;
        apiResponse.setResponseCode(sourceResponse.getResponseCode());
        apiResponse.setResponseMessage(sourceResponse.getResponseMessage());
        apiResponse.setPath(sourceResponse.getPath());
        apiResponse.setTimestamp(sourceResponse.getTimestamp());

        if (Objects.nonNull(sourceResponse.getData())
                && Objects.nonNull(clazz) && clazz.isInstance(sourceResponse.getData())) {
            apiResponse.setData(clazz.cast(sourceResponse.getData()));
        }

        return apiResponse;
    }

    public static <T> ApiResponse<T> copyResponse(ApiResponse<T> apiResponse, ApiResponse<?> sourceResponse) {
        return copyResponse(apiResponse, sourceResponse, null);
    }
}

