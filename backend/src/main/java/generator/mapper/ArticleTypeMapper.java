package generator.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import generator.domain.ArticleType;

/**
 * @author huawei
 * @description 针对表【article_type】的数据库操作Mapper
 * @createDate 2022-06-08 09:28:25 @Entity generator.domain.ArticleType
 */
@Mapper
public interface ArticleTypeMapper {


    /**
     * sql 注入
     *
     * @param column 列明
     * @param order  desc
     * @return 集合
     */
    List<ArticleType> findAllOrder(@Param("column") String column, @Param("order") String order);

    /**
     * sql 注入
     *
     * @param table 表
     * @return 集合
     */
    List<ArticleType> findAllByTable(String table);

}
