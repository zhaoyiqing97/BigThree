package generator.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import generator.domain.ArticleInfo;

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
}
