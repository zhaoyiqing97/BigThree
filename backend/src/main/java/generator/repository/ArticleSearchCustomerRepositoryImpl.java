package generator.repository;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;

import generator.domain.es.ArticleSearch;
import lombok.AllArgsConstructor;

/**
 * @author wmx
 * */
@AllArgsConstructor
@Repository
@Lazy
public class ArticleSearchCustomerRepositoryImpl implements ArticleSearchCustomerRepository {

  private final ElasticsearchOperations operations;

  @Override
  public SearchHits<ArticleSearch> findBySearch(String search) {
    final NativeSearchQuery query = new NativeSearchQueryBuilder()
        .withQuery(
            QueryBuilders.boolQuery()
                .should(QueryBuilders.matchQuery("title", search))
                .should(QueryBuilders.matchQuery("title.pinyin", search))
                .should(QueryBuilders.matchQuery("markdownContent", search))
                .should(QueryBuilders.matchQuery("markdownContent.pinyin", search))
        )
        .withHighlightBuilder(
            new HighlightBuilder()
                .field("name")
                .field("name.pinyin")
                .field("markdownContent")
                .field("markdownContent.pinyin")
                .preTags("<em class='text-red-500'>")
                .postTags("</em>")
        )
        .build();
    return operations.search(query, ArticleSearch.class);
  }
}
