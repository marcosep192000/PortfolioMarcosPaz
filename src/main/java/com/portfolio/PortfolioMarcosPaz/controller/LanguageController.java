package com.portfolio.PortfolioMarcosPaz.controller;

import com.portfolio.PortfolioMarcosPaz.models.request.LanguageRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.LanguageResponse;
import com.portfolio.PortfolioMarcosPaz.service.impl.LanguageImpl;
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
    public List<ResponseEntity<LanguageResponse>> allLanguages()
    {

        return null;
    }




}
