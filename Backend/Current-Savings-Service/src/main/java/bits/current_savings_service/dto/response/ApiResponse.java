package bits.current_savings_service.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {

    private String responseCode;
    private String responseMessage;
    private T data;
    private String path;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
