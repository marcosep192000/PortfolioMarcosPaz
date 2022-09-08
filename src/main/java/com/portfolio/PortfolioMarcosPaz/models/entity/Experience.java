package com.portfolio.PortfolioMarcosPaz.models.entity;

import javax.persistence.*;

@Entity
@Table(name = Experience.TABLE_NAME)
public class Experience {
    public static final String TABLE_NAME = "experience";
    public static final String COLUMN_ID_NAME = "id";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    private Long id;
    private String Name;
    private String logo;
    private String startDate;
    private String finallyDate;
    private String description;
    private Boolean state = true ;

    public Experience() {
    }

    public Experience(Long id, String name, String logo, String startDate, String finallyDate, String description, Boolean state) {
        this.id = id;
        Name = name;
        this.logo = logo;
        this.startDate = startDate;
        this.finallyDate = finallyDate;
        this.description = description;
        this.state = state;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinallyDate() {
        return finallyDate;
    }

    public void setFinallyDate(String finallyDate) {
        this.finallyDate = finallyDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState(boolean state) {
        return this.state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}