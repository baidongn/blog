package com.blog.blog_gateway_gateway.moudle;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 15:45 2021/6/18
 */
@Data
@AllArgsConstructor
public class OauthUser implements UserDetails, CredentialsContainer {


    private User user;
    private org.springframework.security.core.userdetails.User userinfo;


    @Override
    public void eraseCredentials() {
        userinfo.eraseCredentials();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userinfo.getAuthorities();
    }

    @Override
    public String getPassword() {
        return userinfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userinfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userinfo.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userinfo.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userinfo.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return userinfo.isEnabled();
    }
}
