package generator.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

import generator.domain.ArticleInfo;
import generator.domain.bo.ArticleInfoBO;
import generator.repository.ArticleInfoRepository;
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

    public ArticleInfoServiceImpl(ArticleInfoRepository articleInfoRepository) {
        this.articleInfoRepository = articleInfoRepository;
    }

    @Override
    public Page<ArticleInfo> page(Pageable pageable) {
        return articleInfoRepository.findAll(pageable);
    }

    @Override
    public void publishArticle(Long userId, ArticleInfoBO bo) {
        val articleInfo = bo.to(ArticleInfo.class);
        articleInfo.setAuthorId(userId);
        articleInfo.setCreateUser(userId);
        articleInfo.setReleaseTime(new Date());
        articleInfo.setCreateTime(new Date());
        articleInfo.setId(System.currentTimeMillis());
        articleInfoRepository.saveAndFlush(articleInfo);
    }
}
