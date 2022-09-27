package com.portfolio.PortfolioMarcosPaz.models.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


public class EducationRequest implements Serializable {
    private Long id;
    @NotBlank(message = "Title not Empty")
    private String titleExperience;
    @NotBlank(message = "Not Empty")
    private String nameBussines;
    @NotBlank(message = "Not Empty")
    private String dateStart;
    @NotBlank(message = "Not Empty")
    private String dateEnd;
    private String ubicacion;
    private String sector;


    public EducationRequest() {
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

    public EducationRequest(Long id, String titleExperience, String nameBussines, String dateStart, String dateEnd, String ubicacion, String sector) {
        this.id = id;
        this.titleExperience = titleExperience;
        this.nameBussines = nameBussines;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.ubicacion = ubicacion;
        this.sector = sector;




    }
}
