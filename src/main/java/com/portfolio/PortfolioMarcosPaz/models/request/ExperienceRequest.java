package com.portfolio.PortfolioMarcosPaz.models.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


public class ExperienceRequest implements Serializable {
    @NotBlank(message = "Name is empty.")
    private  String Name;
    private  String logo;
    @NotBlank(message = " Select Date for start")
    private  String startDate;
    @NotBlank(message = "Select Date for finally.")
    private  String finallyDate;
    @NotBlank(message = "Description  is empty.")
    private  String description;

    public ExperienceRequest(String name, String logo, String startDate, String finallyDate, String description) {
        Name = name;
        this.logo = logo;
        this.startDate = startDate;
        this.finallyDate = finallyDate;
        this.description = description;
    }
    public ExperienceRequest() {
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
}
