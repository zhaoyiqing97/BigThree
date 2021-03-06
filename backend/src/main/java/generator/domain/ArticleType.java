package generator.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author zhaoyiqing @TableName article_type
 */
@TableName(value = "article_type")
@Data
public class ArticleType implements Serializable {
  @TableField(exist = false)
  private static final long serialVersionUID = 1L;
  /** 主键 */
  @TableId private Long id;
  /** 类型名 */
  private String typename;
  /** 0为普通用户可以获取权限,1为管理员独享权限 */
  private Integer power;
  /** 0代表存在,1代表已经被删除 */
  private Integer state;
  /** */
  private Date createTime;
  /** */
  private Long createUser;
  /** */
  private Date updateTime;
  /** */
  private Long updateUser;
}
