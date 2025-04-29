package bits.current_savings_service.common.exceptions;


import bits.current_savings_service.domain.enums.ResponseMessage;

public class FeignClientException extends CustomRootException {
    public FeignClientException(ResponseMessage responseMessage) {
        super(responseMessage);
    }

    public FeignClientException(String messageCode, String messageKey) {
        super(messageCode, messageKey);
    }
}
