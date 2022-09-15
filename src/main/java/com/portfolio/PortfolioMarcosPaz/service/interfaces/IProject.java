package com.portfolio.PortfolioMarcosPaz.service.interfaces;

import com.portfolio.PortfolioMarcosPaz.models.entity.Experience;
import com.portfolio.PortfolioMarcosPaz.models.entity.Project;
import com.portfolio.PortfolioMarcosPaz.models.request.ExperienceRequest;
import com.portfolio.PortfolioMarcosPaz.models.request.ProjectRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ExperienceResponse;
import com.portfolio.PortfolioMarcosPaz.models.response.ProjectResponse;

import java.util.List;

public interface IProject {
     ProjectResponse save(ProjectRequest request);
     List<ProjectResponse> allProjects();
     ProjectResponse deleteProject(Long id);
     ProjectResponse updateProject(Long id ,ProjectRequest request);
     void deletProject(Long id);

}
