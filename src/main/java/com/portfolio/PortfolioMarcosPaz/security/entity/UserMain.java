package com.portfolio.PortfolioMarcosPaz.security.entity;

import javax.persistence.*;

@Entity
public class UserMain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    private Long id;

    public static final String COLUMN_ID_NAME = "id";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
