package com.portfolio.PortfolioMarcosPaz.controller;

import com.portfolio.PortfolioMarcosPaz.models.entity.Experience;
import com.portfolio.PortfolioMarcosPaz.models.request.ExperienceRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ExperienceResponse;
import com.portfolio.PortfolioMarcosPaz.service.impl.ExperienceIpl;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.mongo.ReactiveStreamsMongoClientDependsOnBeanFactoryPostProcessor;
import org.springframework.boot.autoconfigure.session.RedisSessionProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/experience")
@CrossOrigin("http://localhost:4200")
public class ExperienceController {
    @Autowired
    ExperienceIpl experienceService;


    @PostMapping("/create")
    public ResponseEntity<ExperienceResponse> create(@Valid @RequestBody ExperienceRequest request){
         experienceService.saveExperience(request);
        return new ResponseEntity(new Message("Experience created!"), HttpStatus.ACCEPTED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ExperienceResponse> update( @PathVariable Long id, @RequestBody  ExperienceRequest request) {
        experienceService.updateExperience(id,request);
        return new ResponseEntity(new Message("Experience update!"), HttpStatus.ACCEPTED);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<ExperienceResponse> delete (@PathVariable Long id) {
         experienceService.deletExperience(id);
        return new ResponseEntity(new Message("Experience Deleted !"), HttpStatus.ACCEPTED);
    }
    @GetMapping("/all")
    public ResponseEntity<ExperienceResponse> all() {
        List<Experience> list =  experienceService.allExperiences();
        return new ResponseEntity(list, HttpStatus.ACCEPTED);
    }

}

