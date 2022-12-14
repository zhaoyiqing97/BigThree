package generator.service;

import java.util.List;

import generator.domain.es.ArticleSearch;
import generator.domain.vo.SearchVO;

/**
 * 搜索接口
 *
 * @author liubin
 */
public interface SearchService {

  /**
   * 保存文章
   *
   * @param search 文章
   */
  void saveArticleSearch(ArticleSearch search);

  /**
   * 搜索文章
   *
   * @param title   标题
   * @param content 内容
   * @return 结果
   */
  List<SearchVO> findByTitleOrMarkdownContent(String title, String content);
}
