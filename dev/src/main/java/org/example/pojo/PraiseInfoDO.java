package org.example.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class PraiseInfoDO {
    private int comment_id; //评论id
    private Date create_time; //
    private int create_user; //
    private int id; //
    private int state; //0代表存在,1代表已经被删除
    private Date update_time; //
    private int update_user; //
    private int userid; //点赞者id
}
