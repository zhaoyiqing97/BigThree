package generator.filter;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 王明鑫 过滤器
 */
@Component
@Slf4j
public class BigThreeFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, @NonNull HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String requestUri = request.getRequestURI();
        long start = System.currentTimeMillis();
        log.info("before doFilter {}", requestUri);
        filterChain.doFilter(request, response);
        log.info("uri [{}],use [{}]ms", requestUri, (System.currentTimeMillis() - start));
    }
}
