package generator.service.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;

import java.util.List;

import generator.domain.es.ArticleSearch;
import generator.domain.vo.SearchVO;
import generator.service.SearchService;
import lombok.extern.slf4j.Slf4j;

/**
 * 搜索接口 无实现，异常
 *
 * @author liubin
 */
@Service
@Slf4j
@ConditionalOnMissingBean(EsSearchServiceImpl.class)
public class NoSearchServiceImpl implements SearchService {
  @Override
  public void saveArticleSearch(ArticleSearch search) {
    log.warn("[saveArticleSearch] no elasticsearch no search");
  }

  @Override
  public List<SearchVO> findByTitleOrMarkdownContent(String search) {
    throw new UnsupportedOperationException("[findByTitleOrMarkdownContent] no elasticsearch no search");
  }
}
