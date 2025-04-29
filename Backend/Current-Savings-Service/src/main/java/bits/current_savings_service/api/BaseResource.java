package bits.current_savings_service.api;

import bits.current_savings_service.domain.enums.ResponseMessage;
import bits.current_savings_service.service.LocaleMessageService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseResource {

    private LocaleMessageService localeMessageService;

    @Autowired
    public void setLocaleMessageService(LocaleMessageService localeMessageService) {
        this.localeMessageService = localeMessageService;
    }

    public String getMessage(ResponseMessage key) {
        return localeMessageService.getLocalMessage(key);
    }
}
