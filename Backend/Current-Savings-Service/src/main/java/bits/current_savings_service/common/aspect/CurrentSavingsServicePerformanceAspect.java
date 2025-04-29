package bits.current_savings_service.common.aspect;

import bits.current_savings_service.common.logger.CommonPerformanceLoggerAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CurrentSavingsServicePerformanceAspect extends CommonPerformanceLoggerAspect {

    @Pointcut("execution(public * bits.current_savings_service.repository..*.*(..))")
    public void currentSavingsRepositoryPerformanceTrace() {
    }

    @Around("currentSavingsRepositoryPerformanceTrace())")
    public Object calculateCurrentSavingsServicePerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        return tracePerformance(joinPoint);
    }

}
