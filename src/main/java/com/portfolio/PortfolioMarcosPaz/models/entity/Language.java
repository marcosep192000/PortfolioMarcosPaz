package com.portfolio.PortfolioMarcosPaz.models.entity;

import lombok.*;
import org.aspectj.bridge.IMessage;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String language;
    @NotBlank(message = "Name is mandatory")
    private String levelEscrito;

    private String levelOral;

    public Language() {
    }

    public Language(Long id, String language, String levelEscrito, String levelOral) {
        this.id = id;

        this.language = language;
        this.levelEscrito = levelEscrito;
        this.levelOral = levelOral;
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