package generator.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author zhaoyiqing @TableName article_type
 */
@Entity
@Data
public class ArticleType implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @Id
    private Long id;
    /**
     * 类型名
     */
    private String typename;
    /**
     * 0为普通用户可以获取权限,1为管理员独享权限
     */
    private Integer power;
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
