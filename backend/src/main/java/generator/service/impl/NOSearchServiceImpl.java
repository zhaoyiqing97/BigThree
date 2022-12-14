package generator.service.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;

import java.util.List;

import generator.domain.es.ArticleSearch;
import generator.domain.vo.SearchVO;
import generator.service.SearchService;

@Service
@ConditionalOnMissingBean(ESSearchServiceImpl.class)
public class NOSearchServiceImpl implements SearchService {
  @Override
  public void saveArticleSearch(ArticleSearch search) {
    throw new UnsupportedOperationException("[saveArticleSearch] no elasticsearch no search");
  }

  @Override
  public List<SearchVO> findByTitleOrMarkdownContent(String title, String content) {
    throw new UnsupportedOperationException("[findByTitleOrMarkdownContent] no elasticsearch no search");
  }
}
