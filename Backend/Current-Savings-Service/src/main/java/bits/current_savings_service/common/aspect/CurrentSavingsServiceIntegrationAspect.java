package bits.current_savings_service.common.aspect;

import bits.current_savings_service.common.logger.CommonIntegrationLoggerAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CurrentSavingsServiceIntegrationAspect extends CommonIntegrationLoggerAspect {

    @Pointcut("execution(public * bits.current_savings_service.rest.client..*.*(..))")
    public void currentSavingsIntegrationTrace() {
    }

    @Around("currentSavingsIntegrationTrace()")
    public Object traceCurrentSavingsIntegration(ProceedingJoinPoint joinPoint) throws Throwable {
        return trace(joinPoint);
    }

}
