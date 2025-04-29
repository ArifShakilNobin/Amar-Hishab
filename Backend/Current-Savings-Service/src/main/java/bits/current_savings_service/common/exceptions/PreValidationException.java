package bits.current_savings_service.common.exceptions;


import bits.current_savings_service.domain.enums.ResponseMessage;

public abstract class PreValidationException extends CustomRootException {
    public PreValidationException(ResponseMessage responseMessage) {
        super(responseMessage);
    }

    public PreValidationException(String messageCode, String messageKey) {
        super(messageCode, messageKey);
    }
}
