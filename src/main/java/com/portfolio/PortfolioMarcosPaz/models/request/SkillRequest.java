package com.portfolio.PortfolioMarcosPaz.models.request;

import javax.validation.constraints.*;
import java.io.Serializable;


public class SkillRequest implements Serializable {
    private  Long id;
    @NotBlank(message = "Name not blanck")
    private String nameSkill;
    @Min(value = 1, message = "min 1 ")
    @Max(value = 100, message = "max 100")
    private int pointSkill;
    @NotBlank(message = "Name not blanck")
    private String imageSkillStack;

    public SkillRequest() {
    }

    public SkillRequest(Long id, String nameSkill, int pointSkill, String imageSkillStack) {
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

    public void setNameSkill() {
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
