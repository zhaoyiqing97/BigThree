package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import generator.domain.ArticleType;
import generator.mapper.ArticleTypeMapper;
import generator.service.ArticleTypeService;

/**
 * @author huawei
 * @description 针对表【article_type】的数据库操作Service实现
 * @createDate 2022-06-08 09:28:25
 */
@Service
public class ArticleTypeServiceImpl extends ServiceImpl<ArticleTypeMapper, ArticleType>
    implements ArticleTypeService {}
