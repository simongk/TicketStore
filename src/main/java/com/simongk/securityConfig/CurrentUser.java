package com.simongk.securityConfig;

import com.simongk.user.Role;
import com.simongk.user.User;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by Szymon Gasienica-Kotelnicki on 21.05.17.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {
    private User user;

    public CurrentUser(User user) {
        super(user.getName(),user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user=user;
    }

    public User getUser(){
        return user;
    }

    public Long getId(){
        return user.getId();
    }

    public Role getRole(){
        return user.getRole();
    }
}
