package com.portfolio.PortfolioMarcosPaz.models.response;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


public class SkillResponse implements Serializable {
    private  Long id;
    @NotBlank(message = "Name not blanck")
    private  String nameSkill;

    private  int pointSkill;
    @NotBlank(message = "Image not blanck")
    private  String imageSkillStack;

    public SkillResponse() {
    }

    public SkillResponse(Long id, String nameSkill, int pointSkill, String imageSkillStack) {
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
