package generator.repository;

import org.springframework.data.elasticsearch.core.SearchHits;

import generator.domain.es.ArticleSearch;

public interface ArticleSearchCustomerRepository {

  SearchHits<ArticleSearch> findBySearch(String search);

}
