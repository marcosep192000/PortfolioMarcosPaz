package com.portfolio.PortfolioMarcosPaz.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = Skill.TABLE_NAME)
public class Skill {
    public static final String TABLE_NAME = "skill";
    public static final String COLUMN_ID_NAME = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)

    private Long id;
    @NotBlank(message = "Name not blanck")
    private  String nameSkill;
    @Min(value = 1, message = "min 1 ")
    @Max(value = 100, message = "max 100")
    private Integer pointSkill;

    private String imageSkillStack;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_skills")
    private Usuario usuario;
    public Skill() {
    }



    public Skill(Long id, String nameSkill, Integer pointSkill, String imageSkillStack, Usuario usuario) {
        this.id = id;
        this.nameSkill = nameSkill;
        this.pointSkill = pointSkill;
        this.imageSkillStack = imageSkillStack;
        this.usuario = usuario;
    }

    public void setPointSkill(Integer pointSkill) {
        this.pointSkill = pointSkill;
    }


    public Long getId() {

        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public int getPointSkill() {
        return pointSkill;
    }

    public void setPointSkill(int pointSkill) {
        this.pointSkill = pointSkill;
    }

    public String getImageSkillStack() {
        return imageSkillStack;
    }

    public void setImageSkillStack(String imageSkillStack) {
        this.imageSkillStack = imageSkillStack;
    }
}