package generator.service.impl;

import com.google.common.collect.Lists;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
  public List<SearchVO> findByTitleOrMarkdownContent(String title, String content) {
    return articleSearchRepository.findByTitleOrMarkdownContent(title, content)
        .stream()
        .map(it -> {
          final ArticleSearch itContent = it.getContent();
          final Map<String, List<String>> highlightFields = it.getHighlightFields();
          return SearchVO.builder()
              .id(itContent.getId())
              .title(highlightFields.getOrDefault("title", Lists.newArrayList(itContent.getTitle())).get(0))
              .content(highlightFields.getOrDefault("markdownContent", Collections.singletonList("")).get(0))
              .build();
        })
        .collect(Collectors.toList());
  }
}
