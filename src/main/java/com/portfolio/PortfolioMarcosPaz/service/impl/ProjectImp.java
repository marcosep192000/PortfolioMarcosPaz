package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Project;
import com.portfolio.PortfolioMarcosPaz.models.mappers.ProjectMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.ExperienceRequest;
import com.portfolio.PortfolioMarcosPaz.models.request.ProjectRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ExperienceResponse;
import com.portfolio.PortfolioMarcosPaz.models.response.ProjectResponse;
import com.portfolio.PortfolioMarcosPaz.repository.ProjectRepository;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.IProject;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectImp implements IProject {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectMapper mapper;
    @Override
    public ProjectResponse save(ProjectRequest request) {
        Project project = mapper.dtoToEntity(request);
        projectRepository.save(project);
        return  mapper.entityToDto(project);
    }
    @Override
    public List<Project> allProjects() {
        return null;
    }
    @Override
    public ProjectResponse deleteProject(Long id) {
        return null;
    }
    @Override
    public ExperienceResponse updateProject(Long id, ExperienceRequest request) {
        return null;
    }
    @Override
    public void deletProject(Long id) {

    }
}
