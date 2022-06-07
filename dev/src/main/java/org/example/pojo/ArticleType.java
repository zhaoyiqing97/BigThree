package org.example.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleType {
    private Date create_time; //
    private int create_user; //
    private int id; //主键
    private int power; //0为普通用户可以获取权限,1为管理员独享权限
    private int state; //0代表存在,1代表已经被删除
    private String typename; //类型名
    private Date update_time; //
    private int update_user; //
}
