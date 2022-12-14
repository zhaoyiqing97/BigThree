package generator.domain.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.data.elasticsearch.annotations.Setting;
import org.springframework.data.elasticsearch.annotations.TermVector;

import lombok.Data;

/**
 * @author zhaoyiqing @TableName article_info
 */

@Data
@Document(indexName = "article-search")
@Setting(settingPath = "/es/index-setting.json")
public class ArticleSearch {

  /**
   * 主键
   */
  @Id
  private Long id;
  /**
   * 文章标题
   */
  @MultiField(
      mainField = @Field(type = FieldType.Text, analyzer = "ikSearchAnalyzer", searchAnalyzer = "ikSearchAnalyzer"),
      otherFields = {
          @InnerField(type = FieldType.Text, suffix = "pinyin", analyzer = "pinyinSimpleIndexAnalyzer", searchAnalyzer = "pinyinSimpleIndexAnalyzer", termVector = TermVector.with_offsets)
      }
  )
  private String title;
  /**
   * 文章内容
   */
  @MultiField(
      mainField = @Field(type = FieldType.Text, analyzer = "ikSearchAnalyzer", searchAnalyzer = "ikSearchAnalyzer"),
      otherFields = {
          @InnerField(type = FieldType.Text, suffix = "pinyin", analyzer = "pinyinSimpleIndexAnalyzer", searchAnalyzer = "pinyinSimpleIndexAnalyzer", termVector = TermVector.with_offsets)
      }
  )
  private String markdownContent;

}
