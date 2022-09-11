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
     List<Project> allProjects();
     ProjectResponse deleteProject(Long id);
     ExperienceResponse updateProject(Long id , ExperienceRequest request);
     void deletProject(Long id);

}
