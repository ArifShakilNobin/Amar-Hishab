package bits.current_savings_service.common.exceptions;


import bits.current_savings_service.dto.response.ApiResponse;
import bits.current_savings_service.domain.Enums.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Object> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String errorMsg = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Validation failed");

        log.warn("Validation error: {}", errorMsg);
        return buildErrorResponse((ResponseMessage.VALIDATION_FAILED.getResponseCode()), errorMsg, request.getRequestURI());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Object> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        log.warn("IllegalArgumentException: {}", ex.getMessage());
        return buildErrorResponse(ResponseMessage.VALIDATION_FAILED.getResponseCode(), ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Object> handleGenericException(Exception ex, HttpServletRequest request) {
        log.error("Unhandled exception: {}", ex.getMessage(), ex);
        return buildErrorResponse(
                ResponseMessage.VALIDATION_FAILED.getResponseCode(),
                ResponseMessage.VALIDATION_FAILED.getResponseMessage(),
                request.getRequestURI()
        );

    }

    private ApiResponse<Object> buildErrorResponse(int code, String message, String path) {
        return ApiResponse.builder()
                .responseCode(code)
                .responseMessage(message)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();
    }
}

