package generator.domain.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

import lombok.Data;

/**
 * @author zhaoyiqing @TableName article_info
 */

@Data
@Document(indexName = "article-search")
@Setting(settingPath = "/es/index-setting.json")
@Mapping(mappingPath = "/es/article-search.json")
public class ArticleSearch {

    /**
     * 主键
     */
    @Id
    private Long id;
    /**
     * 文章标题
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word,pinyin_word", searchAnalyzer = "ik_max_word,pinyin_word")
    private String title;
    /**
     * 文章内容
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word,pinyin_word", searchAnalyzer = "ik_max_word,pinyin_word")
    private String markdownContent;
    /**
     * 文章内容
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word,pinyin_word", searchAnalyzer = "ik_max_word,pinyin_word")
    private String htmlContent;

}
