package bits.current_savings_service.service;

import bits.current_savings_service.common.exceptions.RecordNotFoundException;
import bits.current_savings_service.common.logger.CurrentSavingsServiceLogger;
import bits.current_savings_service.domain.Enums.ResponseMessage;
import bits.current_savings_service.infrastructure.messaging.kafka.EventWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

public class BaseService {

    private LocaleMessageService messageService;
    private HttpServletRequest request;
    protected CurrentSavingsServiceLogger logger;
    protected ObjectMapper mapper;

    public static final String CURRENT_USER_CONTEXT_HEADER = "CurrentContext";

    @Autowired
    public void setMessageService(LocaleMessageService messageService) {
        this.messageService = messageService;
    }

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Autowired
    public void setLogger(CurrentSavingsServiceLogger logger) {
        this.logger = logger;
    }

    public String getMessage(ResponseMessage key, Object... objects) {
        return messageService.getLocalMessage(key, objects);
    }

    @Autowired
    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public Optional<String> getHeaderValue(String headerName) {

        try {
            return Optional.ofNullable(request.getHeader(headerName));
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage(), ex);
        }

        return Optional.empty();
    }

    public Date getCurrentDate() {
        return new Date();
    }

    public <T> String writeJsonString(T obj) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return StringUtils.EMPTY;
    }

    private String getCurrentUserContextHeaderValue() {
        Optional<String> userTokenOpt = getHeaderValue(CURRENT_USER_CONTEXT_HEADER);

        if (userTokenOpt.isEmpty())
            throw new RecordNotFoundException(ResponseMessage.RECORD_NOT_FOUND.getResponseMessage());

        return userTokenOpt.get();
    }

    public <T> T toObject(String jsonString, Class<T> clazz) {
        try {
            return mapper.readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public EventWrapper<Object> prepareKafkaObject(String requestId, Timestamp timestamp, Object data) {
        return new EventWrapper<>(requestId, timestamp, data);
    }

    public <T> void printTrace(T obj) {
        logger.trace(writeJsonString(obj));
    }

    public void setHeaderValue(final String key, final String value) {
        try {
            request.setAttribute(key, value);
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage(), ex);
        }
    }

}
