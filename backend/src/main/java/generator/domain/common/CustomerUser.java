package generator.domain.common;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

import generator.domain.UserInfo;
import lombok.Getter;
import lombok.ToString;

/**
 * CustomerUser.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-16 : base version.
 */
@Getter
@ToString
public class CustomerUser extends User {

    private UserInfo userInfo;

    public CustomerUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomerUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public CustomerUser(String username, String password, Collection<? extends GrantedAuthority> authorities, UserInfo userInfo) {
        super(username, password, authorities);
        this.userInfo = userInfo;
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        userInfo.setPassword(null);
    }
}
