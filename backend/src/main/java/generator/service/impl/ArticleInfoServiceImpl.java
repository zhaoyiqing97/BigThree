package generator.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import generator.domain.ArticleInfo;
import generator.domain.bo.ArticleInfoBO;
import generator.domain.es.ArticleSearch;
import generator.domain.vo.SearchVO;
import generator.repository.ArticleInfoRepository;
import generator.service.ArticleInfoService;
import generator.service.SearchService;
import lombok.AllArgsConstructor;
import lombok.val;

/**
 * @author HangZ
 */
@Service
@AllArgsConstructor
public class ArticleInfoServiceImpl
    implements ArticleInfoService {

  private final ArticleInfoRepository articleInfoRepository;

  private final SearchService searchService;

  @Override
  public Page<ArticleInfo> page(Pageable pageable) {
    return articleInfoRepository.findAll(pageable);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void publishArticle(Long userId, ArticleInfoBO bo) {
    val articleInfo = bo.to(ArticleInfo.class);
    articleInfo.setAuthorId(userId);
    articleInfo.setCreateUser(userId);
    articleInfo.setReleaseTime(new Date());
    articleInfo.setCreateTime(new Date());
    articleInfo.setId(System.currentTimeMillis());
    articleInfoRepository.saveAndFlush(articleInfo);

    val search = new ArticleSearch();
    search.setId(articleInfo.getId());
    search.setTitle(bo.getTitle());
    search.setMarkdownContent(bo.getMarkdownContent());
    searchService.saveArticleSearch(search);
  }

  @Override
  public List<SearchVO> search(String search) {
    return searchService.findByTitleOrMarkdownContent(search);

  }

  @Override
  public Optional<ArticleInfo> find(Long id) {
    return articleInfoRepository.findById(id);
  }
}
