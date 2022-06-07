package org.example.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class CommentInfoDO {
    private int article_id; //评论的文章id
    private int author_id; //评论者id,对应user_info中的id
    private String comm_content; //文章内容
    private Date create_time; //
    private int create_user; //
    private int id; //主键
    private int is_accept; //是否被采纳,0代表未被采纳,1代表已经被采纳
    private int praise_points; //被点赞的数量
    private Date release_time; //发布时间
    private int state; //0代表存在,1代表已经被删除
    private Date update_time; //
    private int update_user; //
}
