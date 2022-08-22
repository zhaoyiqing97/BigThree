package generator.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import generator.domain.common.CustomerUser;
import generator.mapper.UserInfoMapper;
import generator.service.UserInfoService;
import lombok.RequiredArgsConstructor;

/**
 * 刘b 我真求求了 把阿里规范去了吧
 *
 * @author WangMingXin
 */
@Service("UserDetailsServiceImpl")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService, UserInfoService {

    private final UserInfoMapper userInfoMapper;

    /**
     * 根据userName 查询用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //需要构造出 org.springframework.security.core.userdetails.User 对象并返回
        if (StringUtils.isBlank(username)) {
            throw new RuntimeException("用户不能为空");
        }

        return Optional.ofNullable(userInfoMapper.selectByUserName(username))
                .map(it -> new CustomerUser(it.getEmail(), it.getPassword(), new ArrayList<>(), it))
                .orElseThrow(() -> new UsernameNotFoundException("用户不存在"));
    }
}
