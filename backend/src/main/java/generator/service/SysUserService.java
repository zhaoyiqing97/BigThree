package generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import generator.domain.UserInfo;

/**
 * 用户service
 * @author WangMingXin
 * */
public interface SysUserService extends IService<UserInfo> {
    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    UserInfo selectByUserName(String userName);
}
