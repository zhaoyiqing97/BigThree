package generator.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * WebMvcConfig.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-15 : base version.
 */
@Configuration
public class WebMvcConfig {

    /**
     * web 请求的转换器，自动识别配置的spring bean
     *
     * @param objectMapper objectMapper
     * @return MappingJackson2HttpMessageConverter
     */
    @Bean
    public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter(ObjectMapper objectMapper) {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }
}
