package com.portfolio.PortfolioMarcosPaz.controller;

import com.portfolio.PortfolioMarcosPaz.models.request.EducationRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.EducationResponse;
import com.portfolio.PortfolioMarcosPaz.service.impl.EducationImpl;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/education")
public class EducationController {

    @Autowired
    EducationImpl education;


    @PostMapping("/create")
    public ResponseEntity<EducationResponse> create( @Valid @RequestBody EducationRequest request){
        education.createEducation(request);
        return new ResponseEntity(new Message("Created"), HttpStatus.CREATED);
    }




}
