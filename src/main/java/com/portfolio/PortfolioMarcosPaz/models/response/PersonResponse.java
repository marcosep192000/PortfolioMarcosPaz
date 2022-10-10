package com.portfolio.PortfolioMarcosPaz.models.response;

import com.portfolio.PortfolioMarcosPaz.models.request.EducationDto;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

public class PersonResponse implements Serializable {
    private  Long id;
    @NotBlank
    private  String name;
    @NotBlank
    private  String lastName;
    @NotBlank
    private  String perfilPhotograpy;
    @NotBlank
    private  String Direction;
    @NotBlank
    private String state;
    @NotBlank
    private  String province;
    @Email
    private  String mail;
    @NotBlank
    private  String stack;
    @NotBlank
    private  String aboutMe;
    private  Set<EducationDto> educationList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPerfilPhotograpy() {
        return perfilPhotograpy;
    }

    public void setPerfilPhotograpy(String perfilPhotograpy) {
        this.perfilPhotograpy = perfilPhotograpy;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public Set<EducationDto> getEducationList() {
        return educationList;
    }

    public void setEducationList(Set<EducationDto> educationList) {
        this.educationList = educationList;
    }
}
