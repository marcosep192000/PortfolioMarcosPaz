package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Project;
import com.portfolio.PortfolioMarcosPaz.models.mappers.ProjectMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.ProjectRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ProjectResponse;
import com.portfolio.PortfolioMarcosPaz.repository.ProjectRepository;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.IProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<ProjectResponse> allProjects() {
        List<Project>projectList=  projectRepository.findAll();
        return mapper.allProjects(projectList) ;
    }
    @Override
    public ProjectResponse deleteProject(Long id) {
        return null;
    }
    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Optional<Project> project = projectRepository.findById(id);

        Project projectNew =  mapper.updateEntity(project.get(),request);
        projectRepository.save(projectNew);
        return mapper.entityToDto(projectNew);
    }
    @Override
    public void deletProject(Long id) {

    }
}
