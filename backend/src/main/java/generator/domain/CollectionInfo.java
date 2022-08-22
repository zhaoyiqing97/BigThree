package generator.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author liubin @TableName collection_info
 */

@Data
public class CollectionInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Long id;
    /**
     * user id
     */
    private Long collectionId;
    /**
     * 收藏文章id
     */
    private Long articleId;
    /**
     * 收藏时间
     */
    private Date collectionTime;
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
