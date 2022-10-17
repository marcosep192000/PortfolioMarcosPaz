package com.portfolio.PortfolioMarcosPaz.controller;

import com.portfolio.PortfolioMarcosPaz.models.entity.Education;
import com.portfolio.PortfolioMarcosPaz.models.request.EducationRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.EducationResponse;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import com.portfolio.PortfolioMarcosPaz.security.repository.UsuarioRepository;
import com.portfolio.PortfolioMarcosPaz.service.impl.EducationImpl;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.GetUser;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/education")
public class EducationController {
@Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EducationImpl education;
 //@PreAuthorize("hasRole('admin')")
    @PostMapping("/create")
    public ResponseEntity<?> create( @Valid @RequestBody EducationRequest request){
        ResponseEntity<?> responseEntity= education.createEducation(request);
       return new ResponseEntity(responseEntity.getBody(), responseEntity.getStatusCode());
    }

    @GetMapping("/all")
    public ResponseEntity<List<EducationResponse>> allEducation( ){
        List<Education> educations = education.allEducation();
     return new ResponseEntity (educations,HttpStatus.ACCEPTED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@Valid @PathVariable Long id,@RequestBody EducationRequest request)
    {
        education.uptdateEducation(id,request);
        return new ResponseEntity<>(new Message("Update"),HttpStatus.ACCEPTED);
    }
    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
          Message e =  education.deleteEducation(id);
        return new ResponseEntity(e ,HttpStatus.ACCEPTED);
    }

}

