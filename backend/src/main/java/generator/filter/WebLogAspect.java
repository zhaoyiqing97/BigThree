package generator.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

/**
 * WebLogAspect.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-15 : base version.
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    private final ObjectMapper objectMapper;

    public WebLogAspect(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * 以 controller 包下定义的所有请求为切入点.
     */
    @Pointcut("execution(* generator.controller..*.*(..))")
    public void webLog() {

    }

    /**
     * 在切点之前织入
     *
     * @param joinPoint joinPoint对象
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws JsonProcessingException {
        log.info("execution : [{}]", joinPoint.toLongString());
        val args = joinPoint.getArgs();
        val argsStr = objectMapper.writer().writeValueAsString(args);
        log.info("args : [{}]", argsStr);
    }

}
