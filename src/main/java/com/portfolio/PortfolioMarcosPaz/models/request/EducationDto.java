package com.portfolio.PortfolioMarcosPaz.models.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class EducationDto implements Serializable {
    @NotBlank(message = "Title not Empty")
    private final String titleExperience;
    @NotBlank(message = "Not Empty")
    private final String nameBussines;
    @NotBlank(message = "Not Empty")
    private final String dateStart;
    @NotBlank(message = "Not Empty")
    private final String dateEnd;
    private final String ubicacion;
    private final String sector;
    private final boolean state;
}
