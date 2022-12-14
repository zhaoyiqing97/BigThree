package generator.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;

/**
 * ElasticsearchConfiguration.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-18 : base version.
 */
@Configuration
@AllArgsConstructor
@EnableElasticsearchRepositories("generator.repository")
@ConditionalOnProperty("big-three.enable.elasticsearch")
public class ElasticsearchConfiguration extends AbstractElasticsearchConfiguration {

  private final ElasticsearchProperties properties;

  @Override
  @Bean
  @NonNull
  public RestHighLevelClient elasticsearchClient() {
    final String[] uris = properties.getUris().toArray(new String[0]);
    final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
        .connectedTo(uris)
        .withBasicAuth(properties.getUsername(), properties.getPassword())
        .build();

    return RestClients.create(clientConfiguration).rest();
  }
}
