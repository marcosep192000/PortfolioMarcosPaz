package com.portfolio.PortfolioMarcosPaz.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    private Long id;
    @NotBlank
    private String name ;
    @NotBlank
    private String lastName;
    @NotBlank
    private String perfilPhotograpy;
    @NotBlank
    private String Direction;
    @NotBlank
    private String state;
    @NotBlank
    private String province;
    @Email
    private String mail;
    @NotBlank
    private String stack;
    @NotBlank
    private String aboutMe;


    @OneToMany(mappedBy= "person",cascade = CascadeType.ALL)
    List<Education> educationList;

    public Person() {
    }

    public Person(Long id, String name, String lastName, String perfilPhotograpy, String direction, String state, String province, String mail, String stack, String aboutMe, List<Education> educationList) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.perfilPhotograpy = perfilPhotograpy;
        Direction = direction;
        this.state = state;
        this.province = province;
        this.mail = mail;
        this.stack = stack;
        this.aboutMe = aboutMe;
        this.educationList = educationList;
    }

    public static final String COLUMN_ID_NAME = "id";

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

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }
}
