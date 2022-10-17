package com.portfolio.PortfolioMarcosPaz.security.entity;

import com.portfolio.PortfolioMarcosPaz.models.entity.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Clase para la base de datos
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;
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

@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
private List<Education> educationList;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Experience> experienceList;
 @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
 private List<Project> projectList;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Skill> skillList ;

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public void addSkills(Skill skill)
    {
        skillList.add(skill);
        skill.setUsuario(this);
    }

    @OneToMany(mappedBy = "usuario" ,cascade = CascadeType.ALL)
    private List<Language> languajeList= new ArrayList<>();

    public void addLanguaje(Language language) {
        this.languajeList.add(language);
        language.setUsuario(this);
    }

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombreUsuario, String email, String password, String name, String lastName, String perfilPhotograpy, String direction, String state, String province, String mail, String stack, String aboutMe, Set<Language> languageSet, Set<Rol> roles) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.perfilPhotograpy = perfilPhotograpy;
        Direction = direction;
        this.state = state;
        this.province = province;
        this.mail = mail;
        this.stack = stack;
        this.aboutMe = aboutMe;

        this.roles = roles;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    public List<Language> getLanguajeList() {
        return languajeList;
    }

    public void setLanguajeList(List<Language> languajeList) {
        this.languajeList = languajeList;
    }


    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }



    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }


    public List<Language> getLanguaje() {
        return languajeList;
    }

    public void setLanguaje(List<Language> languaje) {
        this.languajeList = languaje;
    }

    public Usuario(String nombreUsuario, String email, String password) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
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
}
