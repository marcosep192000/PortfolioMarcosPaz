package com.portfolio.PortfolioMarcosPaz.controller;

import com.portfolio.PortfolioMarcosPaz.models.entity.Language;
import com.portfolio.PortfolioMarcosPaz.models.request.LanguageRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.LanguageResponse;
import com.portfolio.PortfolioMarcosPaz.security.repository.UsuarioRepository;
import com.portfolio.PortfolioMarcosPaz.service.impl.LanguageImpl;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("/language")
public class LanguageController {
@Autowired
    LanguageImpl languageService;
@Autowired
UsuarioRepository usuarioRepo;


    @CrossOrigin(origins = {"http://localhost:4200" , "https://portfolio-2fdd4.web.app"})
@PostMapping("/create")
    public ResponseEntity<?>save(@Valid @RequestBody LanguageRequest request) {
   ResponseEntity<?> responseEntity= languageService.save(request);
    return new ResponseEntity(responseEntity.getBody(),responseEntity.getStatusCode()) ;
}
    @CrossOrigin(origins = {"http://localhost:4200" , "https://portfolio-2fdd4.web.app"})
@PutMapping("/update/{id}")
    public ResponseEntity<LanguageResponse> update(@Valid @RequestBody LanguageRequest request,@PathVariable Long id) {

    LanguageResponse l= languageService.update(request);
    return new ResponseEntity("Language update",HttpStatus.ACCEPTED);
}
    @CrossOrigin(origins = {"http://localhost:4200" , "https://portfolio-2fdd4.web.app"})

    @GetMapping("/all-languages")
    public ResponseEntity<List<LanguageResponse>> allLanguages()
    {
      List<Language> l=  languageService.allLanguages();
        return new ResponseEntity(l,HttpStatus.ACCEPTED) ;
    }
    @CrossOrigin(origins = {"http://localhost:4200" , "https://portfolio-2fdd4.web.app"})
    @DeleteMapping("/delete-language")
    public ResponseEntity<?> DeleteLanguage(@Valid Long id ){
        languageService.deletLanguage(id);
    return  new ResponseEntity( new Message("Language Deleted"),HttpStatus.ACCEPTED);
    }
}
