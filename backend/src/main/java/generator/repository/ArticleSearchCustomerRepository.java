package generator.repository;

import org.springframework.data.elasticsearch.core.SearchHits;

import generator.domain.es.ArticleSearch;

/**
 * @author wmx
 * */
public interface ArticleSearchCustomerRepository {
/**
 * 查询
 * @param search
 * */
  SearchHits<ArticleSearch> findBySearch(String search);

}
