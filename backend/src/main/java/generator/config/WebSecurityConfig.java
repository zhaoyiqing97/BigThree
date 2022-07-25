package generator.config;

import com.google.common.collect.Lists;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import generator.filter.BigThreeFilter;
import generator.service.impl.UserDetailsServiceImpl;
import lombok.val;

/**
 * Security 登录配置
 *
 * @author WangMingXin
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final BigThreeFilter bigThreeFilter;

  private final ProjectSetting projectSetting;

  public WebSecurityConfig(BigThreeFilter bigThreeFilter, ProjectSetting projectSetting) {
    this.bigThreeFilter = bigThreeFilter;
    this.projectSetting = projectSetting;
  }

  /** 提供用户信息，这里没有从数据库查询用户信息，在内存中模拟 */
  @Override
  public UserDetailsService userDetailsService() {
    // 获取用户账号密码及权限信息
    return new UserDetailsServiceImpl();
  }

  /** 密码编码器：不加密 */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService());
  }

  /** 授权规则配置 */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // 授权配置
    http.authorizeRequests()
        // 登录路径放行
        .antMatchers("/login", "/list")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        //                .loginPage("/loginHtml")
        .loginProcessingUrl("/doLogin")
        .successForwardUrl("/loginSuccess")
        //                .successHandler()//指定登录成功的处理逻辑类
        //                .failureHandler()//指定登录失败的处理逻辑类
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
  }
}
