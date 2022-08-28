package com.portfolio.PortfolioMarcosPaz.models.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


public class LanguageRequest implements Serializable {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private  String language;
    @NotBlank(message = "Name is mandatory")
    private  String levelEscrito;
    @NotBlank(message = "Name is mandatory")
    private  String levelOral;

    public LanguageRequest(Long id, String language, String levelEscrito, String levelOral) {
        this.id = id;
        this.language = language;
        this.levelEscrito = levelEscrito;
        this.levelOral = levelOral;
    }

    public LanguageRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLevelEscrito() {
        return levelEscrito;
    }

    public void setLevelEscrito(String levelEscrito) {
        this.levelEscrito = levelEscrito;
    }

    public String getLevelOral() {
        return levelOral;
    }

    public void setLevelOral(String levelOral) {
        this.levelOral = levelOral;
    }
}
