package generator.domain.bo;

import generator.domain.ArticleInfo;
import generator.domain.common.Out;
import lombok.Data;

/**
 * ArticleInfoBO.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-17 : base version.
 */
@Data
public class ArticleInfoBO implements Out<ArticleInfoBO, ArticleInfo> {

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章类型id,对应article_type中的id
     */
    private Long typeId;


    /**
     * 悬赏飞吻数
     */
    private Integer payKiss;

    /**
     * 是否是否结帖,0代表不是,1代表是
     */
    private Integer isDone;
    /**
     * 文章内容
     */
    private String markdownContent;
    /**
     * 文章内容
     */
    private String htmlContent;
}
