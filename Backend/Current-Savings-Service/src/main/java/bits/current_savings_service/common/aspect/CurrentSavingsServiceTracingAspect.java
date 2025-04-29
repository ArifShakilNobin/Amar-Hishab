package bits.current_savings_service.common.aspect;

import bits.current_savings_service.common.logger.CommonTraceLoggerAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CurrentSavingsServiceTracingAspect extends CommonTraceLoggerAspect {

    @Pointcut("execution(* bits.current_savings_service.api..*(..)))")
    public void currentSavingsControllerAspect() {
    }

    @Pointcut("execution(* bits.current_savings_service.service..*.*(..)))")
    public void currentSavingsServiceTrace() {
    }

    @Around("currentSavingsServiceTrace() && !noLogging()")
    public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
        return trace(joinPoint);
    }

    @Around("currentSavingsControllerAspect()")
    public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
        return trace(joinPoint);
    }

}
