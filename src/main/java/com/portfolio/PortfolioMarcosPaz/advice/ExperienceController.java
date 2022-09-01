package com.portfolio.PortfolioMarcosPaz.advice;

import com.portfolio.PortfolioMarcosPaz.models.request.ExperienceRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ExperienceResponse;
import com.portfolio.PortfolioMarcosPaz.service.impl.ExperienceIpl;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.mongo.ReactiveStreamsMongoClientDependsOnBeanFactoryPostProcessor;
import org.springframework.boot.autoconfigure.session.RedisSessionProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Controller
@RequestMapping("/experience")
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
    @PostMapping("/delet")
    public ResponseEntity<ExperienceResponse> delete (@Valid @RequestBody Long id) {
        experienceService.deletExperience(id);
        return new ResponseEntity(new Message("Experience created!"), HttpStatus.ACCEPTED);
    }
    @PostMapping("/all")
    public ResponseEntity<ExperienceResponse> all() {
        experienceService.allExperiences();
        return new ResponseEntity(new Message("Experience created!"), HttpStatus.ACCEPTED);
    }
}
