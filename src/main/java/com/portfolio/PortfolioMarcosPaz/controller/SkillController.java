package com.portfolio.PortfolioMarcosPaz.controller;

import com.portfolio.PortfolioMarcosPaz.models.request.SkillRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.SkillResponse;
import com.portfolio.PortfolioMarcosPaz.service.impl.SkillImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    SkillImpl skillService;

     @PostMapping("/create")
    public SkillResponse create(@Valid @RequestBody SkillRequest request) {
    return null ;
    }
    @GetMapping("/all")
    public EntityResponse<List<SkillResponse>>all(){
        return null;
    }
    @PutMapping("/update/{id}")
    public SkillResponse update(@Valid @PathVariable Long id ,  @RequestBody SkillRequest request) {
            return null ;
    }

    @DeleteMapping("/delete/{id}")
    public SkillResponse delete(@PathVariable Long id) {
        return null ;
    }





}
