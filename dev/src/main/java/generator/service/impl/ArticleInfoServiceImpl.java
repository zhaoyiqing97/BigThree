package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.ArticleInfo;
import generator.service.ArticleInfoService;
import generator.mapper.ArticleInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author HangZ
* @description 针对表【article_info】的数据库操作Service实现
* @createDate 2022-06-08 09:53:40
*/
@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo>
    implements ArticleInfoService{

}




