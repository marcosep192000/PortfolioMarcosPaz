package com.portfolio.PortfolioMarcosPaz.security.entity;

import com.portfolio.PortfolioMarcosPaz.security.enums.RoleName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public static final String COLUMN_ID_NAME = "id";

    public Role() {
    }

    public Role(Long id, RoleName roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
