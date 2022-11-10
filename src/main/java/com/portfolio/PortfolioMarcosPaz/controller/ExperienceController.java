package com.portfolio.PortfolioMarcosPaz.controller;

import com.portfolio.PortfolioMarcosPaz.models.entity.Experience;
import com.portfolio.PortfolioMarcosPaz.models.entity.Project;
import com.portfolio.PortfolioMarcosPaz.models.request.ExperienceRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ExperienceResponse;
import com.portfolio.PortfolioMarcosPaz.repository.ExperienceRepository;
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
@CrossOrigin(origins = {"http://localhost:4200" , "https://portfolio-2fdd4.web.app"})
@RequestMapping("/experience")

public class ExperienceController {
    @Autowired
    ExperienceIpl experienceService;
@Autowired
    ExperienceRepository experienceRepository;
    @CrossOrigin(origins = {"http://localhost:4200" , "https://portfolio-2fdd4.web.app"})
    @PostMapping("/create")
    public ResponseEntity<ExperienceResponse> create(@Valid @RequestBody ExperienceRequest request){
         experienceService.saveExperience(request);
        return new ResponseEntity(new Message("Experience created!"), HttpStatus.ACCEPTED);
    }@CrossOrigin(origins = {"http://localhost:4200" , "https://portfolio-2fdd4.web.app"})
    @PutMapping("/update/{id}")
    public ResponseEntity<ExperienceResponse> update( @PathVariable Long id, @RequestBody  ExperienceRequest request) {
        experienceService.updateExperience(id,request);
        return new ResponseEntity(new Message("Experience update!"), HttpStatus.ACCEPTED);
    }
    @CrossOrigin(origins = {"http://localhost:4200" , "https://portfolio-2fdd4.web.app"})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ExperienceResponse> delete (@PathVariable Long id ) {
        experienceRepository.deleteById(id);
        return new ResponseEntity(new Message("Experience Deleted !"), HttpStatus.ACCEPTED);
    }@CrossOrigin(origins = {"http://localhost:4200" , "https://portfolio-2fdd4.web.app"})
    @GetMapping("/all")
    public ResponseEntity<ExperienceResponse> all() {
        List<Experience> list =  experienceService.allExperiences();
        return new ResponseEntity(list, HttpStatus.ACCEPTED);
    }@CrossOrigin(origins = {"http://localhost:4200" , "https://portfolio-2fdd4.web.app"})
    @GetMapping("/find/{id}")
    public ResponseEntity<Experience> find(@PathVariable Long id ){
      Experience ex = experienceRepository.findById(id) .orElseThrow(() -> new IllegalStateException("No worker nodes"));
        return  new ResponseEntity(ex,HttpStatus.ACCEPTED);
    }
}

