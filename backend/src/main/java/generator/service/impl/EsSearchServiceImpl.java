package generator.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import generator.domain.es.ArticleSearch;
import generator.domain.vo.SearchVO;
import generator.repository.ArticleSearchRepository;
import generator.service.SearchService;
import lombok.AllArgsConstructor;

/**
 * 搜索接口 es实现
 *
 * @author liubin
 */
@Service
@AllArgsConstructor
@ConditionalOnProperty("big-three.enable.elasticsearch")
public class EsSearchServiceImpl implements SearchService {
  private final ArticleSearchRepository articleSearchRepository;


  @Override
  public void saveArticleSearch(ArticleSearch search) {
    articleSearchRepository.save(search);
  }

  @Override
  public List<SearchVO> findByTitleOrMarkdownContent(String search) {
    return articleSearchRepository.findBySearch(search)
        .stream()
        .map(it -> {
          final ArticleSearch itContent = it.getContent();
          final Map<String, List<String>> highlightFields = it.getHighlightFields();
          final Optional<String> titleOp = Stream.of(highlightFields.get("title"), highlightFields.get("title.pinyin"))
              .filter(CollectionUtils::isNotEmpty)
              .map(list -> list.get(0))
              .findFirst();

          final Optional<String> markdownContentOp = Stream.of(highlightFields.get("markdownContent"), highlightFields.get("markdownContent.pinyin"))
              .filter(CollectionUtils::isNotEmpty)
              .map(list -> list.get(0))
              .findFirst();

          return SearchVO.builder()
              .id(itContent.getId())
              .title(titleOp.orElse(itContent.getTitle()))
              .content(markdownContentOp.orElse(""))
              .build();
        })
        .collect(Collectors.toList());
  }
}
