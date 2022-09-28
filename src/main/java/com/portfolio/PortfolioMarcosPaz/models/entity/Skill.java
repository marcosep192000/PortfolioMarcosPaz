package com.portfolio.PortfolioMarcosPaz.models.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "Name not blanck")
    private int pointSkill;
    @NotBlank(message = "Name not blanck")
    private String imageSkillStack;

    public Skill() {
    }

    public Skill(Long id, String nameSkill, int pointSkill, String imageSkillStack) {
        this.id = id;
        this.nameSkill = nameSkill;
        this.pointSkill = pointSkill;
        this.imageSkillStack = imageSkillStack;
    }

    public Long getId() {
        return id;
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