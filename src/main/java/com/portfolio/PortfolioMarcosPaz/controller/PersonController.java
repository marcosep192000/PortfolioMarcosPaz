package com.portfolio.PortfolioMarcosPaz.controller;

import com.portfolio.PortfolioMarcosPaz.models.entity.Person;
import com.portfolio.PortfolioMarcosPaz.models.request.PersonRequest;
import com.portfolio.PortfolioMarcosPaz.service.impl.PersonImp;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/portfolio")

public class PersonController {
    @Autowired
    PersonImp personService;
     @PostMapping("/create")
     public ResponseEntity<?> cretePerson(@Valid @RequestBody PersonRequest request)
     {
         personService.create(request);
         return new ResponseEntity<>(new Message("created"), HttpStatus.CREATED);
     }
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updatePerson(@Valid @PathVariable Long id,@RequestBody PersonRequest request)
    {
        return null ;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Person>> cretePerson()
    {
       List<Person> personList=  personService.all();

        return new ResponseEntity(personList, HttpStatus.ACCEPTED);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deletPerson(@PathVariable Long id)
    {
        return null ;
    }
}
