package generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import generator.domain.UserInfo;
import generator.mapper.UserInfoMapper;
import generator.service.SysUserService;

/**
 * @author WangMingXin
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    @Override
    public Optional<UserInfo> selectByUserName(String userName) {
        return Optional.ofNullable(userInfoMapper.selectByUserName(userName));
    }
}
