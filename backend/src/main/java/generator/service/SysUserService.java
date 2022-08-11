package generator.service;

import java.util.Optional;

import generator.domain.UserInfo;

/**
 * 用户service
 *
 * @author WangMingXin
 */
public interface SysUserService {
    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    Optional<UserInfo> selectByUserName(String userName);
}
