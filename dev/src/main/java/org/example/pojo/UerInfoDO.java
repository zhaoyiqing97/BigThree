package org.example.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UerInfoDO {
    private int active; //0未激活,1为已经激活
    private String active_code; //
    private int authority; //用户权限 0 代表普通用户，1代表管理员
    private String city; //居住城市
    private Date create_time; //
    private int create_user; //
    private String email; //邮箱地址
    private int experience; //经验值，发帖回帖涨经验值
    private String head_url; //头像地址
    private int id; //主键
    private int kiss_num; //飞吻数
    private Date last_sign; //上一次签到天数
    private String nickname; //用户昵称
    private String password; //用户密码
    private Date reg_time; //注册时间
    private int sex; //性别0 男 1 女
    private String sign; //个人签名
    private int sign_days; //连续签到天数
    private int state; //0代表存在,1代表已经被删除
    private Date update_time; //
    private int update_user; //
}
