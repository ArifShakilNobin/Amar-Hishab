package org.bits.service.Domain.Response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
public class ApiResponse {
    private Boolean success;
    private String message;
    private Object data;
    private Long count;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }


    public ApiResponse(Boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(Boolean success, String message, Object data, Long count) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.count = count;
    }

}
