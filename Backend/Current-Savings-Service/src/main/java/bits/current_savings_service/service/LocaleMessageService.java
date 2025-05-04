package bits.current_savings_service.service;

import bits.current_savings_service.domain.Entity.LocaleMessage;
import bits.current_savings_service.domain.Enums.ResponseMessage;
import bits.current_savings_service.domain.enums.SpecialCharsEnum;
import bits.current_savings_service.infrastructure.messaging.redis.Message;
import bits.current_savings_service.repository.LocaleMessageRepository;
import bits.current_savings_service.repository.redis.MessageRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocaleMessageService {

    private final HttpServletRequest request;
    private final MessageSource messageSource;
    private final MessageRepository messageRepository;
    private final LocaleMessageRepository localeMessageRepository;

    public Locale getLocale() {
        return request.getLocale();
    }

    public String getLocalMessage(ResponseMessage key, Object... objects) {
        return messageSource.getMessage(key.getResponseMessage(), objects, getLocale());
    }

    public String getLocalMessage(ResponseMessage key) {
        return this.getLocalMessage(key, getLocale());
    }


    public String getLocalMessage(String key, Object... objects) {
        return messageSource.getMessage(key, objects, getLocale());
    }

    public String getLocalMessage(String key) {
        return messageSource.getMessage(key, null, getLocale());
    }

    public void localMessageSyncWithRedis() {
        List<LocaleMessage> localeMessages = localeMessageRepository.findAll();

        for (LocaleMessage localeMessage : localeMessages) {

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Map<String, String> map = objectMapper.readValue(localeMessage.getContent(), new TypeReference<>() {
                });

                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String id = SpecialCharsEnum.PREFIX.getSign().concat(SpecialCharsEnum.COLON.getSign()).concat(entry.getKey()).concat(SpecialCharsEnum.COLON.getSign()).concat(localeMessage.getLocale());
                    Message message = new Message();
                    message.setId(id);
                    message.setLocale(localeMessage.getLocale());
                    message.setKey(entry.getKey());
                    message.setContent(entry.getValue());
                    messageRepository.save(message);
                }

            } catch (JsonProcessingException ex) {
                log.warn(ex.getMessage());
                ex.printStackTrace();
            }

        }
    }

}
