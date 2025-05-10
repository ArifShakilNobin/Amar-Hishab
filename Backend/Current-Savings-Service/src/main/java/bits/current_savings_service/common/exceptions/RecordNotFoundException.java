package bits.current_savings_service.common.exceptions;


import bits.current_savings_service.domain.Enums.ResponseMessage;
import org.springframework.http.HttpStatus;

public class RecordNotFoundException extends CustomRootException {

    public RecordNotFoundException(ResponseMessage responseMessage) {
        super(responseMessage);
    }

    public RecordNotFoundException(int messageCode, String messageKey) {
        super(messageCode, messageKey);
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
