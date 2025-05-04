package bits.current_savings_service.common.exceptions;


import bits.current_savings_service.domain.Enums.ResponseMessage;

public abstract class CustomRootException extends RuntimeException {

    private String messageCode;

    public CustomRootException(ResponseMessage responseMessage) {
        super(responseMessage.getResponseMessage());
        this.messageCode = responseMessage.getResponseCode();
    }

    public CustomRootException(String messageCode, String messageKey) {
        super(messageKey);
        this.messageCode = messageCode;
    }

    public CustomRootException(String message) {
        super(message);
    }

    public String getMessageCode() {
        return messageCode;
    }
}
