package bits.current_savings_service.rest.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;


@Component
public class FeignClientRequestInterceptor implements RequestInterceptor {

    public static final String CURRENT_USER_CONTEXT_HEADER = "CurrentContext";

    private final HttpServletRequest request;

    public FeignClientRequestInterceptor(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(CURRENT_USER_CONTEXT_HEADER, getCurrentContext());
    }

    private String getCurrentContext() {
        String context = StringUtils.EMPTY;

        try {
            context = request.getHeader(CURRENT_USER_CONTEXT_HEADER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return context;
    }

}
