package com.portfolio.PortfolioMarcosPaz.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;

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
    private Boolean state= true;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_projects")
   private Usuario usuario;

    public static final String COLUMN_ID_NAME = "id";

    public Project() {
    }

    public Project(Long id, String title, String subTitle, String description, String linkRepo, String image, Boolean state, Usuario usuario) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.linkRepo = linkRepo;
        this.image = image;
        this.state = state;
        this.usuario = usuario;
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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
