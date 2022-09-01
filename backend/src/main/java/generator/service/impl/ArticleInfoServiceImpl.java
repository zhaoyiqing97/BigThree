package generator.service.impl;

import com.google.common.collect.Lists;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import generator.domain.ArticleInfo;
import generator.domain.bo.ArticleInfoBO;
import generator.domain.es.ArticleSearch;
import generator.domain.vo.SearchVO;
import generator.repository.ArticleInfoRepository;
import generator.repository.ArticleSearchRepository;
import generator.service.ArticleInfoService;
import lombok.val;

/**
 * @author HangZ
 * @description 针对表【article_info】的数据库操作Service实现
 * @createDate 2022-06-08 09:53:40
 */
@Service
public class ArticleInfoServiceImpl
        implements ArticleInfoService {

    private final ArticleInfoRepository articleInfoRepository;
    private final ArticleSearchRepository articleSearchRepository;

    public ArticleInfoServiceImpl(ArticleInfoRepository articleInfoRepository, ArticleSearchRepository articleSearchRepository) {
        this.articleInfoRepository = articleInfoRepository;
        this.articleSearchRepository = articleSearchRepository;
    }

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
        articleSearchRepository.save(search);
    }

    @Override
    public List<SearchVO> search(String search) {
        return articleSearchRepository.findByTitleOrMarkdownContent(search, search)
                .stream()
                .map(it -> {
                    final ArticleSearch content = it.getContent();
                    final Map<String, List<String>> highlightFields = it.getHighlightFields();
                    return SearchVO.builder()
                            .id(content.getId())
                            .title(highlightFields.getOrDefault("title", Lists.newArrayList(content.getTitle())).get(0))
                            .content(highlightFields.getOrDefault("markdownContent", Collections.singletonList("")).get(0))
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ArticleInfo> find(Long id) {
        return articleInfoRepository.findById(id);
    }
}
