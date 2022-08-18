package generator.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author liubin @TableName praise_info
 */

@Data
public class PraiseInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Long id;
    /**
     * 点赞者id
     */
    private Long userid;
    /**
     * 评论id
     */
    private Long commentId;
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
