package com.portfolio.PortfolioMarcosPaz.models.mappers;

import com.portfolio.PortfolioMarcosPaz.models.entity.Experience;
import com.portfolio.PortfolioMarcosPaz.models.request.ExperienceRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ExperienceResponse;
import org.springframework.stereotype.Component;

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
    public Experience dtoToExperiencia(ExperienceRequest experience) {
            Experience experience1 = new Experience();
            experience1.setId(experience.getId());
            experience1.setName(experience.getName());
            experience1.setLogo(experience.getLogo());
            experience1.setStartDate(experience.getStartDate());
            experience1.setFinallyDate(experience.getFinallyDate());
            experience1.setDescription(experience.getDescription());
            return experience1;
        }
        void updateExperience(Experience experience, ExperienceRequest experienceRequest){
            experience.setName(experience.getName());
            experience.setLogo(experience.getLogo());
            experience.setStartDate(experience.getStartDate());
            experience.setFinallyDate(experience.getFinallyDate());
            experience.setDescription(experience.getDescription());
            }
        void UpdateSoftDelete(Experience experience,ExperienceRequest experienceRequest) {


        }
    }


