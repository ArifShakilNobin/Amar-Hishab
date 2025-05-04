package bits.current_savings_service.common.exceptions;


import bits.current_savings_service.domain.Enums.ResponseMessage;

public class AlreadyExists extends CustomRootException {
    public AlreadyExists(ResponseMessage responseMessage) {
        super(String.valueOf(responseMessage));
    }

    public AlreadyExists(String messageCode, String messageKey) {
        super(messageCode, messageKey);
    }

    public AlreadyExists(String message) {
        super(message);
    }
}
