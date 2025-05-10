package bits.current_savings_service.common.exceptions;


import bits.current_savings_service.domain.Enums.ResponseMessage;
import org.springframework.http.HttpStatus;

public abstract class PreValidationException extends CustomRootException {
    public PreValidationException(ResponseMessage responseMessage) {
        super(responseMessage);
    }

    public PreValidationException(int messageCode, String messageKey) {
        super(messageCode, messageKey);
    }
}
