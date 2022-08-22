package generator.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import generator.domain.ArticleInfo;

/**
 * @author HangZ
 * @description 针对表【article_info】的数据库操作Mapper
 * @createDate 2022-06-08 09:53:40 @Entity generator.domain.ArticleInfo
 */
@Mapper
public interface ArticleInfoMapper {

    /**
     * 获取分类的top5 访问量排序
     *
     * @return 集合
     */
    List<ArticleInfo> groupByTypeTop5();
}
