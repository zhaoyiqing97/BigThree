package org.example.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class MessageInfoDO {
    private int art_id; //相关文章id
    private int comment_id; //相关评论id
    private Date create_time; //
    private int create_user; //
    private int id; //
    private int message_type; //0代表系统消息;1代表评论消息;2代表点赞消息;3代表采纳评论;4代表管理员公告通知
    private int read; //0 未读,1 已读
    private int state; //0代表存在,1代表已经被删除
    private Date update_time; //
    private int update_user; //
    private int userid_from; //发出消息的用户id
    private int userid_to; //接受消息的用户id
}
