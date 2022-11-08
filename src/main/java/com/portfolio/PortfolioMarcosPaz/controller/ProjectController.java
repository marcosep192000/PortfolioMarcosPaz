package com.portfolio.PortfolioMarcosPaz.controller;

import com.portfolio.PortfolioMarcosPaz.models.entity.Project;
import com.portfolio.PortfolioMarcosPaz.models.request.ProjectRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ProjectResponse;
import com.portfolio.PortfolioMarcosPaz.repository.ProjectRepository;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import com.portfolio.PortfolioMarcosPaz.service.impl.ProjectImp;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@CrossOrigin(origins = {"http://localhost:4200" , "https://portfolio-2fdd4.web.app"})
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectImp projectService;
    @Autowired
    ProjectRepository repository ;
    @PostMapping("/create")
    public ResponseEntity<ProjectResponse> save(@Valid @RequestBody ProjectRequest request)
    {
        projectService.save(request);
        return new ResponseEntity(new Message("Project Created"),HttpStatus.CREATED);

    }
    @GetMapping("/all")
    public ResponseEntity<List<ProjectResponse>>allProjets(){
        return new ResponseEntity(projectService.allProjects(),HttpStatus.ACCEPTED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectRequest> updateProject ( @Valid @PathVariable Long id, @RequestBody  ProjectRequest request){

        projectService.updateProject(id,request);
        return new ResponseEntity(new Message("update! "),HttpStatus.ACCEPTED);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Project> find( @PathVariable Long id,@RequestBody Project project ){
        Project project1 = repository.findById(id) .orElseThrow(() -> new IllegalStateException("No worker nodes"));
        return  new ResponseEntity<>(project1,HttpStatus.ACCEPTED);

    }
}
