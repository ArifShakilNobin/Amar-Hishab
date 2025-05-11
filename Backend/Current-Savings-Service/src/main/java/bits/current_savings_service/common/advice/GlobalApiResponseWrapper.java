package bits.current_savings_service.common.advice;

import bits.current_savings_service.domain.Enums.ResponseMessage;
import bits.current_savings_service.dto.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalApiResponseWrapper implements ResponseBodyAdvice<Object> {

    private final HttpServletRequest httpServletRequest;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        String path = httpServletRequest.getRequestURI();

        // Bypass Swagger/OpenAPI endpoints
        if (path.startsWith("/v3/api-docs") || path.startsWith("/swagger-ui") || path.startsWith("/swagger-resources")) {
            return body;
        }
        if (body instanceof ApiResponse<?> apiResponse) {
            if (apiResponse.getPath() == null) {
                apiResponse.setPath(path);
            }
            if (apiResponse.getTimestamp() == null) {
                apiResponse.setTimestamp(LocalDateTime.now());
            }
            return apiResponse;
        }

        return ApiResponse.builder()
                .responseCode(ResponseMessage.OPERATION_SUCCESSFUL.getResponseCode())
                .responseMessage(ResponseMessage.OPERATION_SUCCESSFUL.getResponseMessage())
                .data(body)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
