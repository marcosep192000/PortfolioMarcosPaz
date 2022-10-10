package com.portfolio.PortfolioMarcosPaz.controller;

import com.portfolio.PortfolioMarcosPaz.models.entity.Person;
import com.portfolio.PortfolioMarcosPaz.models.request.PersonRequest;
import com.portfolio.PortfolioMarcosPaz.service.impl.PersonImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/portfolio")

public class PersonController {
    @Autowired
    PersonImp personService;
     @PostMapping("/create")
     public ResponseEntity<?> cretePerson(@Valid @RequestBody PersonRequest request)
     {
         return null ;
     }
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updatePerson(@Valid @PathVariable Long id,@RequestBody PersonRequest request)
    {
        return null ;
    }
    @PostMapping("/all")
    public ResponseEntity<?> cretePerson()
    {
        return null ;
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deletPerson(@PathVariable Long id)
    {
        return null ;
    }
}
