package com.devproject.tediproject.security;

import com.devproject.tediproject.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserPrincipal implements UserDetails {

    private User user;
    private String role;
    private Collection<? extends GrantedAuthority> authorities;


    public UserPrincipal(User user, String role, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.role = role;
        this.authorities = authorities;
    }

    public UserPrincipal(User user) {
        this.user = user;

        if (user.getAdmin() == null ){
            this.role = "ROLE_PROFESSIONAL";
        }   else {
            this.role = "ROLE_ADMIN";
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(this.role));
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
        return new UserPrincipal(user);
    }

    public User get(){ return this.user; }

    public Integer getId() {
        return this.user.getId();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPrincipal)) return false;
        UserPrincipal that = (UserPrincipal) o;
        return user.equals(that.user) && role.equals(that.role) && getAuthorities().equals(that.getAuthorities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, role, getAuthorities());
    }
}