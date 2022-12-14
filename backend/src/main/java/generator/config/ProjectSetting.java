package generator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * ProjectSetting.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-07-25 : base version.
 */
@Configuration
@ConfigurationProperties("big-three")
@Data
public class ProjectSetting {
  /**
   * 允许跨域的域名
   */
  private String[] corsMappings;

  /**
   * 开启功能模块
   */
  private OtherEnable enable;

  @Data
  static class OtherEnable {
    /**
     * es 检索模块
     */
    private boolean elasticsearch = true;
  }
}

