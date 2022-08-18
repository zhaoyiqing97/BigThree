package generator.repository;

import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.HighlightParameters;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import generator.domain.es.ArticleSearch;

/**
 * ArticleSearchRepository.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-18 : base version.
 */
@Repository
public interface ArticleSearchRepository extends ElasticsearchRepository<ArticleSearch, Long> {

    @Highlight(fields = {
            @HighlightField(name = "title", parameters = @HighlightParameters(preTags = "<em class='text-red-500'>", postTags = "</em>")),
            @HighlightField(name = "htmlContent", parameters = @HighlightParameters(preTags = "<em class='text-red-500'>", postTags = "</em>"))
    })
    List<SearchHit<ArticleSearch>> findByTitleOrHtmlContent(String title, String content);
}
