package generator.service;

import java.util.List;

import generator.domain.es.ArticleSearch;
import generator.domain.vo.SearchVO;

public interface SearchService {

  void saveArticleSearch(ArticleSearch search);

  List<SearchVO> findByTitleOrMarkdownContent(String title, String content);
}
