package com.portfolio.PortfolioMarcosPaz.models.mappers;

import com.portfolio.PortfolioMarcosPaz.models.entity.Experience;
import com.portfolio.PortfolioMarcosPaz.models.request.ExperienceRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ExperienceResponse;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExperienceMapper {



    public ExperienceResponse experienceToDto(Experience experience){
            ExperienceResponse response = new ExperienceResponse();
            response.setName(experience.getName());
            response.setLogo(experience.getLogo());
            response.setStartDate(experience.getStartDate());
            response.setFinallyDate(experience.getFinallyDate());
            response.setDescription(experience.getDescription());
            return response;
    }
    public Experience dtoToExperiencia(ExperienceRequest experience, Usuario usuario ) {
        Experience experience1 = new Experience();
        experience1.setId(experience.getId());
        experience1.setName(experience.getName());
        experience1.setLogo(experience.getLogo());
        experience1.setStartDate(experience.getStartDate());
        experience1.setFinallyDate(experience.getFinallyDate());
        experience1.setDescription(experience.getDescription());
        experience1.setUsuario(usuario);
        return experience1;
    }
            public Experience updateExperience(Experience experience, ExperienceRequest experienceRequest){
            experience.setName(experienceRequest.getName());
            experience.setLogo(experienceRequest.getLogo());
            experience.setStartDate(experienceRequest.getStartDate());
            experience.setFinallyDate(experienceRequest.getFinallyDate());
            experience.setDescription(experienceRequest.getDescription());
                return experience;
            }
        public Experience UpdateSoftDelete(Experience experience,boolean state )
        {
             experience.setState(state);
             return  experience;
        }
    }


