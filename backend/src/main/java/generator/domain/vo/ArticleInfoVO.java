package generator.domain.vo;

import java.util.Date;

import generator.domain.ArticleInfo;
import generator.domain.common.Out;
import lombok.Data;

/**
 * @author zhaoyiqing @TableName article_info
 */

@Data
public class ArticleInfoVO implements Out<ArticleInfoVO, ArticleInfo> {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 作者id,对应user_info中的id
     */
    private String authorName;
    /**
     * 发布时间
     */
    private Date releaseTime;
    /**
     * 文章类型id,对应article_type中的id
     */
    private String typeName;
    /**
     * 文章浏览量
     */
    private Long visitNum;
    /**
     * 文章评论量
     */
    private Integer commentNum;
    /**
     * 悬赏飞吻数
     */
    private Integer payKiss;
    /**
     * 是否是精华帖,0代表不是,1代表是
     */
    private Integer cream;
    /**
     * 是否是置顶帖,0代表不是,1代表是
     */
    private Integer stick;
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

    @Override
    public ArticleInfoVO from(ArticleInfo entity) {
        final ArticleInfoVO res = Out.super.from(entity);
        res.setAuthorName(entity.getUserInfo().getNickname());
        res.setTypeName(entity.getArticleType().getTypename());
        // todo
        res.setHtmlContent(null);
        res.setMarkdownContent(null);
        return res;
    }
}
