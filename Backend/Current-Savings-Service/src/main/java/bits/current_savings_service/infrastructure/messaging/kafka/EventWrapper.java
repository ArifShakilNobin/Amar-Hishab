package bits.current_savings_service.infrastructure.messaging.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventWrapper<T> implements Serializable {
    private String requestId;
    private Timestamp timestamp;
    private T data;
}