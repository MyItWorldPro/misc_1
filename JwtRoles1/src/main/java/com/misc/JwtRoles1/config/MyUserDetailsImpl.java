package com.misc.JwtRoles1.config;

import com.misc.JwtRoles1.entity.MyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetailsImpl implements UserDetails {

    private String myname;
    private String mypassword;
    private List<GrantedAuthority> myauthorities;

    public MyUserDetailsImpl(MyUser myUser) {
        myname=myUser.getMyname();
        mypassword=myUser.getMypassword();
        myauthorities= Arrays.stream(myUser.getMyroles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return myauthorities;
    }

    @Override
    public String getPassword() {
        return mypassword;
    }

    @Override
    public String getUsername() {
        return myname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
