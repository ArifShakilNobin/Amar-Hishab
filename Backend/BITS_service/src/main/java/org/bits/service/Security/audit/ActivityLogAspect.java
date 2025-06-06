package org.bits.service.Security.audit;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.bits.service.Domain.Audit.AuditLog;
import org.bits.service.Repository.AuditLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class ActivityLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(ActivityLogAspect.class);

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private AuditLogRepository auditLogRepository;

    @AfterReturning("execution(* org.bits.service..*Controller.*(..))")
    public void logActivity(JoinPoint joinPoint) {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            String entity = joinPoint.getSignature().getDeclaringTypeName();
            String operation = joinPoint.getSignature().getName();

            // Get IP and country from request headers
            String ipAddress = httpServletRequest.getHeader("Client-IP");
            String country = httpServletRequest.getHeader("Client-Country");

            AuditLog log = new AuditLog();
            log.setUsername(username);
            log.setEntity(entity);
            log.setOperation(operation);
            log.setTimestamp(LocalDateTime.now());
            log.setIpAddress(ipAddress);
            log.setCountry(country);

            logger.info("Saving audit log: {}", log);

            auditLogRepository.save(log);
        } catch (Exception e) {
            logger.error("Error saving audit log", e);
        }
    }
}
