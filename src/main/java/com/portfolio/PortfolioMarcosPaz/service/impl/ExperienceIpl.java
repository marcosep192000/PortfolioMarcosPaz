package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Experience;
import com.portfolio.PortfolioMarcosPaz.models.entity.Language;
import com.portfolio.PortfolioMarcosPaz.models.mappers.ExperienceMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.ExperienceRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ExperienceResponse;
import com.portfolio.PortfolioMarcosPaz.repository.ExperienceRepository;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.IExperience;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public ExperienceResponse updateExperience(ExperienceRequest request) {
        return null;
    }

    @Override
    public List<Language> allExperiences() {
        return null;
    }

    @Override
    public void deletExperience(Long id) {

    }
}
