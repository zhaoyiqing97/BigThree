package generator.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import generator.domain.ArticleInfo;
import generator.domain.bo.ArticleInfoBO;
import generator.domain.vo.SearchVO;

/**
 * @author HangZ
 * @description 针对表【article_info】的数据库操作Service
 * @createDate 2022-06-08 09:53:40
 */
@Service
public interface ArticleInfoService {

    /**
     * page article info page
     *
     * @param pageable pageable
     * @return page obj
     */
    Page<ArticleInfo> page(Pageable pageable);

    /**
     * 发布文章
     *
     * @param userId user
     * @param bo     article
     */
    void publishArticle(Long userId, ArticleInfoBO bo);

    /**
     * 搜索文章
     *
     * @param search 字符
     * @return page obj
     */
    List<SearchVO> search(String search);

}
