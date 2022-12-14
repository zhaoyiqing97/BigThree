package generator.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.lang.NonNull;

/**
 * ElasticsearchConfiguration.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-18 : base version.
 */
@Configuration
@EnableElasticsearchRepositories("generator.repository")
@ConditionalOnProperty("big-three.enable.elasticsearch")
public class ElasticsearchConfiguration extends AbstractElasticsearchConfiguration {
  @Override
  @Bean
  @NonNull
  public RestHighLevelClient elasticsearchClient() {
    final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
        .connectedTo("localhost:9200")
        .withBasicAuth("elastic", "ZAQ!2wsx")
        .build();

    return RestClients.create(clientConfiguration).rest();
  }
}
