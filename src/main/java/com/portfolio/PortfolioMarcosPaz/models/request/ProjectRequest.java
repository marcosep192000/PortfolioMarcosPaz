package com.portfolio.PortfolioMarcosPaz.models.request;

import lombok.Data;

import java.io.Serializable;


public class ProjectRequest implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String description;
    private String linkRepo;
    private String image;
    private String state;

    public ProjectRequest() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getLinkRepo() {
        return linkRepo;
    }

    public String getImage() {
        return image;
    }

    public String getState() {
        return state;
    }

    public ProjectRequest(Long id, String title, String subTitle, String description, String linkRepo, String image, String state) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.linkRepo = linkRepo;
        this.image = image;
        this.state = state;

    }
}
