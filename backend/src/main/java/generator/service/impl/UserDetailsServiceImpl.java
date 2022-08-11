package generator.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import generator.service.SysUserService;
import lombok.RequiredArgsConstructor;

/**
 * 刘b 我真求求了 把阿里规范去了吧
 *
 * @author WangMingXin
 */
@Service("UserDetailsServiceImpl")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SysUserService sysUserService;

    /**
     * 根据userName 查询用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //需要构造出 org.springframework.security.core.userdetails.User 对象并返回
        if (StringUtils.isBlank(username)) {
            throw new RuntimeException("用户不能为空");
        }

        return sysUserService.selectByUserName(username)
                .map(it -> new User(it.getNickname(), it.getPassword(), true, true, true, true, new ArrayList<>()))
                .orElseThrow(() -> new UsernameNotFoundException("用户不存在"));
    }
}
