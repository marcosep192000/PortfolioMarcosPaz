package com.portfolio.PortfolioMarcosPaz.models.entity;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)

    private Long id;
    private String title;
    private String subTitle;
    private String description;
    private String linkRepo;
    private String image ;
    private String state;

    public static final String COLUMN_ID_NAME = "id";

    public Project() {
    }

    public Project(Long id, String title, String subTitle, String description, String linkRepo, String image, String state) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.linkRepo = linkRepo;
        this.image = image;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkRepo() {
        return linkRepo;
    }

    public void setLinkRepo(String linkRepo) {
        this.linkRepo = linkRepo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
