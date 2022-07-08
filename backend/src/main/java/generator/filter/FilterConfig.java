package generator.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author 王明鑫
 * 过滤器配置
 * */
@Configuration
public class FilterConfig {

    @Resource
    private BigThreeFilter bigThreeFilter;

    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(bigThreeFilter);
        registration.addUrlPatterns("/*");
        registration.setName("bigThreeFilter");
        registration.setOrder(1);
        return registration;
    }
}
