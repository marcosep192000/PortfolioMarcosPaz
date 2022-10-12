package com.portfolio.PortfolioMarcosPaz.models.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;


public class PersonRequest implements Serializable {
    @NotBlank
    private  String name;
    @NotBlank
    private  String lastName;
    @NotBlank
    private  String perfilPhotography;
    @NotBlank
    private  String Direction;
    @NotBlank
    private  String state;
    @NotBlank
    private  String province;
    @Email
    private  String mail;
    @NotBlank
    private  String stack;
    @NotBlank
    private  String aboutMe;
    private  Set<EducationDto> educationList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonRequest(String name, String lastName, String perfilPhotography, String direction, String state, String province, String mail, String stack, String aboutMe) {
        this.name = name;
        this.lastName = lastName;
        this.perfilPhotography = perfilPhotography;
        Direction = direction;
        this.state = state;
        this.province = province;
        this.mail = mail;
        this.stack = stack;
        this.aboutMe = aboutMe;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPerfilPhotography() {
        return perfilPhotography;
    }

    public void setPerfilPhotography(String perfilPhotography) {
        this.perfilPhotography = perfilPhotography;
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
}
