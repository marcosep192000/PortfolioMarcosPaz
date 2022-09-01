package com.portfolio.PortfolioMarcosPaz.service.interfaces;

import com.portfolio.PortfolioMarcosPaz.models.entity.Language;
import com.portfolio.PortfolioMarcosPaz.models.request.ExperienceRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ExperienceResponse;

import java.util.List;

public interface IExperience {
    ExperienceResponse saveExperience(ExperienceRequest request);
    ExperienceResponse updateExperience(Long id , ExperienceRequest request);
    List<Language> allExperiences();
    void deletExperience(Long id);
}
