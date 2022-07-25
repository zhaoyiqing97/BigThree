package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.UserInfo;
import generator.mapper.UserInfoMapper;
import generator.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WangMingXin
 * */
@Service
public class SysUserServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>  implements SysUserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    @Override
    public UserInfo selectByUserName(String userName) {
        return userInfoMapper.selectByUserName(userName);
    }
}
