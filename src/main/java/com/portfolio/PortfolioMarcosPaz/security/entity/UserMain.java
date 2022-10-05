package com.portfolio.PortfolioMarcosPaz.security.entity;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserMain implements UserDetails {

    private String  name;
    private String nameUser;
    private  String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;



    public static  UserMain build (User user){
        List<GrantedAuthority> authorities =
                user.getRoleSet().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                        .collect(Collectors.toList());
        return new UserMain(user.getName(), user.getNameUser(), user.getEmail(),user.getPassword(),authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public UserMain() {
    }

    public UserMain(String name, String nameUser, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.nameUser = nameUser;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nameUser;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
