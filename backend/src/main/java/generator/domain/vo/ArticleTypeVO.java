package generator.domain.vo;

import generator.domain.ArticleType;
import generator.domain.common.Out;
import lombok.Data;

/**
 * @author zhaoyiqing @TableName article_type
 */
@Data
public class ArticleTypeVO implements Out<ArticleTypeVO, ArticleType> {

    /**
     * 主键
     */
    private Long id;
    /**
     * 类型名
     */
    private String typename;
    /**
     * 0为普通用户可以获取权限,1为管理员独享权限
     */
    private Integer power;
}
