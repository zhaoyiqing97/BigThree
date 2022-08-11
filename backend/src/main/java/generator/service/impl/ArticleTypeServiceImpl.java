package generator.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import generator.domain.ArticleType;
import generator.mapper.ArticleTypeMapper;
import generator.service.ArticleTypeService;

/**
 * @author huawei
 * @description 针对表【article_type】的数据库操作Service实现
 * @createDate 2022-06-08 09:28:25
 */
@Service
public class ArticleTypeServiceImpl
        implements ArticleTypeService {

    private final ArticleTypeMapper articleTypeMapper;

    public ArticleTypeServiceImpl(ArticleTypeMapper articleTypeMapper) {
        this.articleTypeMapper = articleTypeMapper;
    }

    @Override
    public List<ArticleType> selectAll() {
        return articleTypeMapper.findAllOrder("id", "desc");
    }
}
