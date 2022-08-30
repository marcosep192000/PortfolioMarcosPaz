package com.portfolio.PortfolioMarcosPaz.controller;

import com.portfolio.PortfolioMarcosPaz.models.entity.Language;
import com.portfolio.PortfolioMarcosPaz.models.request.LanguageRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.LanguageResponse;
import com.portfolio.PortfolioMarcosPaz.repository.LanguageRepository;
import com.portfolio.PortfolioMarcosPaz.service.impl.LanguageImpl;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/language")
public class LanguageController {
@Autowired
    LanguageImpl languageService;
@PostMapping("/create-language")
    public ResponseEntity<LanguageResponse>save( @Valid  @RequestBody LanguageRequest request) {
    return new ResponseEntity(languageService.save(request),HttpStatus.CREATED) ;
}
    @PutMapping("/update-language")
    public ResponseEntity<LanguageResponse> update(@Valid @RequestBody LanguageRequest request) {
    LanguageResponse l= languageService.update(request);
    return new ResponseEntity("Language update",HttpStatus.ACCEPTED);
}
    @GetMapping("/all-languages")
    public ResponseEntity<List<LanguageResponse>> allLanguages()
    {
      List<Language> l=  languageService.allLanguages();
        return new ResponseEntity(l,HttpStatus.ACCEPTED) ;
    }
    @DeleteMapping("/delete-language")
    public ResponseEntity<?> DeleteLanguage(@Valid Long id ){
        languageService.deletLanguage(id);
    return  new ResponseEntity( new Message("Language Deleted"),HttpStatus.ACCEPTED);
    }
}
