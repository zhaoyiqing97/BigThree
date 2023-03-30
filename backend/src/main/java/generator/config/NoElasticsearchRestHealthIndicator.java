package generator.config;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import generator.service.impl.EsSearchServiceImpl;
import lombok.extern.slf4j.Slf4j;
/**
 * @author wmx
 * */
@Component("elasticsearchHealthIndicator")
@Slf4j
@ConditionalOnMissingBean(EsSearchServiceImpl.class)
public class NoElasticsearchRestHealthIndicator extends AbstractHealthIndicator {
  @Override
  protected void doHealthCheck(Health.Builder builder) {
    log.info("NoElasticsearchRestHealthIndicator.doHealthCheck");
    builder.up().withDetail("always up", "Elasticsearch si disable");
  }
}
