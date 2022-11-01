package com.portfolio.PortfolioMarcosPaz.models.mappers;

import com.portfolio.PortfolioMarcosPaz.models.entity.Education;
import com.portfolio.PortfolioMarcosPaz.models.request.EducationRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.EducationResponse;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EducationMapper {

    public Education dtoToEntity(EducationRequest request , Usuario usuario){
        Education education = new Education();
        education.setTitleExperience(request.getTitleExperience());
        education.setNameBussines(request.getNameBussines());
        education.setDateEnd(request.getDateEnd());
        education.setDateStart(request.getDateStart());
        education.setUbicacion(request.getUbicacion());
        education.setUsuario(usuario);
        return education;
    }
    public EducationResponse entityToDto(Education education){
        EducationResponse response = new EducationResponse();
        response.setTitleExperience(education.getTitleExperience());
       response.setNameBussines(education.getNameBussines());
        response.setDateEnd(education.getDateEnd());
        response.setDateStart(education.getDateStart());
        response.setUbicacion(education.getUbicacion());
        return  response ;
    }
    public Education update(EducationRequest request , Education education){
        education.setTitleExperience(request.getTitleExperience());
        education.setNameBussines(request.getNameBussines());
        education.setDateEnd(request.getDateEnd());
        education.setDateStart(request.getDateStart());
        education.setUbicacion(request.getUbicacion());
        return education;
    }
}
