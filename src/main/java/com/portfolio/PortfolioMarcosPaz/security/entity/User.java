package com.portfolio.PortfolioMarcosPaz.security.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)

    private Long id;
    @NotNull
    private String  name;
    @NotNull
    private String nameUser;
    @NotNull
    @Email
    private  String email;
    @NotNull
    private String password;
    @NotNull
    @ManyToMany
    @JoinTable(name= "user_role",joinColumns=@JoinColumn(name= "user_id"),
     inverseJoinColumns = @JoinColumn (name="role_id"))
    private Set<Role> roleSet = new HashSet<>();


    public static final String COLUMN_ID_NAME = "id";


    public User() {
    }

    public User(String name, String nameUser, String email, String password) {
        this.name = name;
        this.nameUser = nameUser;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
