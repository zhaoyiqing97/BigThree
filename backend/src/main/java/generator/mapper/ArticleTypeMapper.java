package generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import generator.domain.ArticleType;

/**
 * @author huawei
 * @description 针对表【article_type】的数据库操作Mapper
 * @createDate 2022-06-08 09:28:25 @Entity generator.domain.ArticleType
 */
@Mapper
public interface ArticleTypeMapper extends BaseMapper<ArticleType> {


/**
* sql 注入
 * @param column 列明
 * @param order desc
 * @return 集合
*/
    List<ArticleType> findAllOrder(String column,String order);

/**
* sql 注入
 * @param table 表
 * @return 集合
*/
    List<ArticleType> findAllByTable(String table);

}
