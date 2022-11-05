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

    @Column(unique = true)
    private String nombreUsuario;

    @Email
    @Column(unique = true)
    private String email;


    private String password;

    private String name ;

    private String lastName;

    private String perfilPhotograpy;


    private String state;

    private String province;

    private String stack;


    private String aboutMe;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
private List<Education> educationList;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Experience> experienceList;
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
 private List<Project> projectList;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Skill> skillList ;

    @OneToMany(mappedBy = "usuario" ,cascade = CascadeType.ALL)
    private List<Language> languajeList= new ArrayList<>();


    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombreUsuario, String email, String password, String name, String lastName, String perfilPhotograpy, String direction, String state, String province, String mail, String stack, String aboutMe, Set<Rol> roles, List<Education> educationList, List<Experience> experienceList, List<Project> projectList, List<Skill> skillList, List<Language> languajeList) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.perfilPhotograpy = perfilPhotograpy;

        this.state = state;
        this.province = province;

        this.stack = stack;
        this.aboutMe = aboutMe;
        this.roles = roles;
        this.educationList = educationList;
        this.experienceList = experienceList;
        this.projectList = projectList;
        this.skillList = skillList;
        this.languajeList = languajeList;
    }

    public Usuario(String nombreUsuario, String email, String encode) {

    }



    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
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

    public List<Language> getLanguajeList() {
        return languajeList;
    }

    public void setLanguajeList(List<Language> languajeList) {
        this.languajeList = languajeList;
    }
}
