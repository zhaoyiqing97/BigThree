package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import generator.domain.ArticleInfo;
import generator.mapper.ArticleInfoMapper;
import generator.service.ArticleInfoService;

/**
 * @author HangZ
 * @description 针对表【article_info】的数据库操作Service实现
 * @createDate 2022-06-08 09:53:40
 */
@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo>
    implements ArticleInfoService {}
