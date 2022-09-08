package com.portfolio.PortfolioMarcosPaz.service.interfaces;

import com.portfolio.PortfolioMarcosPaz.models.entity.Experience;
import com.portfolio.PortfolioMarcosPaz.models.request.ExperienceRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ExperienceResponse;

import java.util.List;

public interface IExperience {
    ExperienceResponse saveExperience(ExperienceRequest request);
    ExperienceResponse updateExperience(Long id , ExperienceRequest request);
    List<Experience> allExperiences();
    void deletExperience(Long id);

}
