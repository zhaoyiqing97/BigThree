package generator.config;

import com.google.common.collect.Lists;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import generator.domain.common.JsonResult;
import generator.filter.BigThreeFilter;
import lombok.val;

/**
 * Security 登录配置
 *
 * @author WangMingXin
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ObjectMapper objectMapper;

    private final BigThreeFilter bigThreeFilter;

    private final ProjectSetting projectSetting;

    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(BigThreeFilter bigThreeFilter, ProjectSetting projectSetting, @Qualifier("UserDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.bigThreeFilter = bigThreeFilter;
        this.projectSetting = projectSetting;
        this.userDetailsService = userDetailsService;
    }

    /**
     * 提供用户信息，这里没有从数据库查询用户信息，在内存中模拟
     */
    @Override
    public UserDetailsService userDetailsService() {
        // 获取用户账号密码及权限信息
        return userDetailsService;
    }

    /**
     * 密码编码器：不加密
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    /**
     * 授权规则配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 授权配置
        http.authorizeRequests()
                .antMatchers("/no-auth/**", "/actuator/**")
                .permitAll()
                .anyRequest()
                .authenticated();

        // login
        http.formLogin()
                .loginProcessingUrl("/login")
                .successForwardUrl("/loginSuccess")
                .failureHandler((request, response, exception) -> {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    val result = new JsonResult();
                    result.setMsg(exception.getMessage());
                    response.getOutputStream().println(
                            objectMapper.writeValueAsString(result)
                    );
                })
                .permitAll();

        // 本地跨域
        if (projectSetting.getCorsMappings() != null) {
            val corsConf = new CorsConfiguration();
            corsConf.setAllowedOrigins(Lists.newArrayList(projectSetting.getCorsMappings()));
            corsConf.setAllowedMethods(Lists.newArrayList("*"));
            val source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", corsConf);
            http.cors().configurationSource(source);
        }

        // 时间过滤器
        http.addFilterAfter(bigThreeFilter, SecurityContextPersistenceFilter.class);

        // 不使用session
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);

        http.csrf().disable();
    }
}
