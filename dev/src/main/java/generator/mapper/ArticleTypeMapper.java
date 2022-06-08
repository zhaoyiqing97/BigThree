package generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import generator.domain.ArticleType;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huawei
 * @description 针对表【article_type】的数据库操作Mapper
 * @createDate 2022-06-08 09:28:25 @Entity generator.domain.ArticleType
 */
@Mapper
public interface ArticleTypeMapper extends BaseMapper<ArticleType> {}
