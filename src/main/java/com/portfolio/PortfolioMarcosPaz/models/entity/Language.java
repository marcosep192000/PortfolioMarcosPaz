package com.portfolio.PortfolioMarcosPaz.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import org.apache.el.stream.Optional;

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
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", nullable = false)
    Usuario usuario;

    public Language() {
    }

    public Language(Long id, String language, String levelEscrito, String levelOral) {
        this.id = id;
        this.language = language;
        this.levelEscrito = levelEscrito;
        this.levelOral = levelOral;

    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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