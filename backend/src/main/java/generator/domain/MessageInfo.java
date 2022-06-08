package generator.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @TableName message_info
 */
@TableName(value = "message_info")
@Data
public class MessageInfo implements Serializable {
  @TableField(exist = false)
  private static final long serialVersionUID = 1L;
  /** */
  @TableId private Long id;
  /** 0代表系统消息;1代表评论消息;2代表点赞消息;3代表采纳评论;4代表管理员公告通知 */
  private Integer messageType;
  /** 接受消息的用户id */
  private Long useridTo;
  /** 发出消息的用户id */
  private Long useridFrom;
  /** 相关文章id */
  private Integer artId;
  /** 相关评论id */
  private Integer commentId;
  /** 0 未读,1 已读 */
  private Integer read;
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
