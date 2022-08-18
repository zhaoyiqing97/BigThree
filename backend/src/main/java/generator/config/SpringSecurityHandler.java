package generator.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import generator.constant.CommonConstant;
import generator.domain.common.CustomerUser;
import generator.domain.common.ResultData;
import generator.domain.vo.UserInVO;
import lombok.RequiredArgsConstructor;
import lombok.val;

/**
 * SpringSecurityHandler.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-17 : base version.
 */
@Component
@RequiredArgsConstructor
public class SpringSecurityHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler, AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        val principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomerUser) {
            val customerUser = (CustomerUser) principal;
            response.setContentType(CommonConstant.RESPONSE_CONTENT_TYPE);
            val result = ResultData.success(new UserInVO().from(customerUser.getUserInfo()));
            try (PrintWriter out = response.getWriter()) {
                out.write(objectMapper.writeValueAsString(result));
                out.flush();
            }
        }
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(CommonConstant.RESPONSE_CONTENT_TYPE);
        val result = new ResultData<>();
        result.setMsg(exception.getMessage());
        try (PrintWriter out = response.getWriter()) {
            out.write(objectMapper.writeValueAsString(result));
            out.flush();
        }
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(CommonConstant.RESPONSE_CONTENT_TYPE);
        val result = new ResultData<>();
        try (PrintWriter out = response.getWriter()) {
            out.write(objectMapper.writeValueAsString(result));
            out.flush();
        }
    }
}
