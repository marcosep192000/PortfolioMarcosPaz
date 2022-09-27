package com.portfolio.PortfolioMarcosPaz.models.mappers;

import com.portfolio.PortfolioMarcosPaz.models.entity.Project;
import com.portfolio.PortfolioMarcosPaz.models.request.ProjectRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ProjectResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectMapper {

    public Project dtoToEntity(ProjectRequest request) {
        Project project = new Project();
        project.setDescription(request.getDescription());
        project.setTitle(request.getTitle());
        project.setSubTitle(request.getSubTitle());
        project.setImage(request.getImage());
        project.setLinkRepo(request.getLinkRepo());
        return project;
    }
    public ProjectResponse entityToDto(Project project) {
        ProjectResponse response = new ProjectResponse();
        response.setId(project.getId());
        response.setDescription(project.getDescription());
        response.setTitle(project.getTitle());
        response.setSubTitle(project.getSubTitle());
        response.setImage(project.getImage());
        response.setLinkRepo(project.getLinkRepo());
        return response;
    }
    public Project updateEntity(Project project, ProjectRequest request ) {
        project.setDescription(request.getDescription());
        project.setTitle(request.getTitle());
        project.setSubTitle(request.getSubTitle());
        project.setImage(request.getImage());
        project.setLinkRepo(request.getLinkRepo());
        return project;

    }
    public List<ProjectResponse> allProjects(List<Project> projectList){
        List<ProjectResponse> responseList = new ArrayList<>();
        projectList.forEach(project -> {
            responseList.add(entityToDto(project))
            ;});
        return  responseList;
    }
}
