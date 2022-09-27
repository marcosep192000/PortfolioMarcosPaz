package com.portfolio.PortfolioMarcosPaz.models.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Table(name = Education.TABLE_NAME)
public class Education {
    public static final String TABLE_NAME = "education";
    public static final String COLUMN_ID_NAME = "id";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    private Long id;
    @NotBlank(message = "Title not Empty")
    private String titleExperience;
    @NotBlank(message = "Not Empty")
    private String nameBussines;
    @NotBlank(message = "Not Empty")
    private String dateStart;
    @NotBlank(message = "Not Empty")
    private String dateEnd;
    private String ubicacion ;
    private String sector;
    private boolean state;


    public Education() {
    }

    public Education(Long id, String titleExperience, String nameBussines, String dateStart, String dateEnd, String ubicacion, String sector, boolean state) {
        this.id = id;
        this.titleExperience = titleExperience;
        this.nameBussines = nameBussines;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.ubicacion = ubicacion;
        this.sector = sector;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleExperience() {
        return titleExperience;
    }

    public void setTitleExperience(String titleExperience) {
        this.titleExperience = titleExperience;
    }

    public String getNameBussines() {
        return nameBussines;
    }

    public void setNameBussines(String nameBussines) {
        this.nameBussines = nameBussines;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}