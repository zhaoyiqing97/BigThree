package generator.domain.vo;

import java.util.Date;

import generator.domain.UserInfo;
import generator.domain.common.Out;
import lombok.Data;

/**
 * @author liubin @TableName user_info
 */

@Data
public class UserInVO implements Out<UserInVO, UserInfo> {

    /**
     * 主键
     */
    private Long id;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 头像地址
     */
    private String headUrl;
    /**
     * 居住城市
     */
    private String city;
    /**
     * 性别0 男 1 女
     */
    private Integer sex;
    /**
     * 个人签名
     */
    private String sign;
    /**
     * 飞吻数
     */
    private Integer kissNum;
    /**
     * 经验值，发帖回帖涨经验值
     */
    private Integer experience;
    /**
     * 用户权限 0 代表普通用户，1代表管理员
     */
    private Integer authority;

    /**
     * 0未激活,1为已经激活
     */
    private Boolean active;
    /**
     *
     */
    private String activeCode;
    /**
     * 上一次签到天数
     */
    private Date lastSign;
    /**
     * 连续签到天数
     */
    private Integer signDays;
}
