package bits.current_savings_service.common.exceptions;


import bits.current_savings_service.domain.Enums.ResponseMessage;

public class RecordNotFoundException extends CustomRootException {

    public RecordNotFoundException(ResponseMessage responseMessage) {
        super(responseMessage);
    }

    public RecordNotFoundException(String messageCode, String messageKey) {
        super(messageCode, messageKey);
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
