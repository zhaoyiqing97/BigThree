package generator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import generator.service.impl.UserDetailsServiceImpl;

/**
 * Security 登录配置
 *
 * @author WangMingXin
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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

  /** 忽略掉的 URL 地址 访问静态文件 */
  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
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
        .antMatchers("/login")
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
        .permitAll()
        .and()
        .csrf()
        .disable();
  }
}
