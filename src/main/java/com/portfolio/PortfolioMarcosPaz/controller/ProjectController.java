package com.portfolio.PortfolioMarcosPaz.controller;

import com.portfolio.PortfolioMarcosPaz.models.request.ProjectRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ProjectResponse;
import com.portfolio.PortfolioMarcosPaz.service.impl.ProjectImp;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectImp projectService;

    @PostMapping("/create")
    public ResponseEntity<ProjectResponse> save(@Valid @RequestBody ProjectRequest request)
    {
        projectService.save(request);
        return new ResponseEntity(new Message("Project Created"),HttpStatus.CREATED);

    }

}
