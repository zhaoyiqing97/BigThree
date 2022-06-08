package generator.mapper;

import generator.domain.ArticleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author HangZ
* @description 针对表【article_info】的数据库操作Mapper
* @createDate 2022-06-08 09:53:40
* @Entity generator.domain.ArticleInfo
*/
@Mapper
public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {

}



