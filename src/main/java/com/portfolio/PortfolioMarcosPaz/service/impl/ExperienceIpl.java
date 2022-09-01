package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Experience;
import com.portfolio.PortfolioMarcosPaz.models.entity.Language;
import com.portfolio.PortfolioMarcosPaz.models.mappers.ExperienceMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.ExperienceRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ExperienceResponse;
import com.portfolio.PortfolioMarcosPaz.repository.ExperienceRepository;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.IExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceIpl implements IExperience {
@Autowired
    ExperienceMapper mapper;
@Autowired
ExperienceRepository experienceService;
    @Override
    public ExperienceResponse saveExperience(ExperienceRequest request) {
        Experience experience = mapper.dtoToExperiencia(request);
        experienceService.save(experience);
        return mapper.experienceToDto(experience);
    }

    @Override
    public ExperienceResponse updateExperience(Long id , ExperienceRequest request) {
        Optional<Experience> experience = experienceService.findById(id);
       Experience experience1 =  mapper.updateExperience(experience.get(),request);
        experienceService.save(experience1);
        return mapper.experienceToDto(experience1);
    }

    @Override
    public List<Language> allExperiences() {
        return null;
    }

    @Override
    public void deletExperience(Long id) {

    }
}
