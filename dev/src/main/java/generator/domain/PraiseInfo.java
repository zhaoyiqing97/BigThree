package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName praise_info
 */
@TableName(value ="praise_info")
@Data
public class PraiseInfo implements Serializable {
    /**
     * 
     */
    @TableId
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}