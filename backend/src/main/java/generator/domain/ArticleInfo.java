package generator.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @autuor zhaoyiqing @TableName article_info
 */
@TableName(value = "article_info")
@Data
public class ArticleInfo implements Serializable {
  @TableField(exist = false)
  private static final long serialVersionUID = 1L;
  /** 主键 */
  @TableId private Long id;
  /** 文章标题 */
  private String title;
  /** 作者id,对应user_info中的id */
  private Long authorId;
  /** 发布时间 */
  private Date releaseTime;
  /** 文章类型id,对应article_type中的id */
  private Long typeId;
  /** 文章浏览量 */
  private Long visitNum;
  /** 文章评论量 */
  private Integer commentNum;
  /** 悬赏飞吻数 */
  private Integer payKiss;
  /** 是否是精华帖,0代表不是,1代表是 */
  private Integer cream;
  /** 是否是置顶帖,0代表不是,1代表是 */
  private Integer stick;
  /** 是否是否结帖,0代表不是,1代表是 */
  private Integer isDone;
  /** 文章内容 */
  private String markdownContent;
  /** 文章内容 */
  private String htmlContent;
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
