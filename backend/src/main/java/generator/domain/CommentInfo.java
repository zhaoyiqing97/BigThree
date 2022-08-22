package generator.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * *
 *
 * @author liubin @TableName comment_info
 */

@Data
public class CommentInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 评论者id,对应user_info中的id
     */
    private Long authorId;
    /**
     * 发布时间
     */
    private Date releaseTime;
    /**
     * 文章内容
     */
    private String commContent;
    /**
     * 评论的文章id
     */
    private Long articleId;
    /**
     * 被点赞的数量
     */
    private Integer praisePoints;
    /**
     * 是否被采纳,0代表未被采纳,1代表已经被采纳
     */
    private Integer isAccept;
    /**
     * 0代表存在,1代表已经被删除
     */
    private Integer state;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Long createUser;
    /**
     *
     */
    private Date updateTime;
    /**
     *
     */
    private Long updateUser;
}
