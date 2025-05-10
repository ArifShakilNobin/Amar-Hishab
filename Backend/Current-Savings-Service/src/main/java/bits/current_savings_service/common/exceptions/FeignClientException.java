package bits.current_savings_service.common.exceptions;


import bits.current_savings_service.domain.Enums.ResponseMessage;
import org.springframework.http.HttpStatus;

public class FeignClientException extends CustomRootException {
    public FeignClientException(ResponseMessage responseMessage) {
        super(responseMessage);
    }

    public FeignClientException(int messageCode, String messageKey) {
        super(messageCode, messageKey);
    }
}
