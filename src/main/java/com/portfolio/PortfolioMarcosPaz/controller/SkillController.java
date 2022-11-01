package com.portfolio.PortfolioMarcosPaz.controller;

import com.portfolio.PortfolioMarcosPaz.models.mappers.LanguageMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.SkillRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.SkillResponse;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import com.portfolio.PortfolioMarcosPaz.security.jwt.JwtProvider;
import com.portfolio.PortfolioMarcosPaz.security.service.RolService;
import com.portfolio.PortfolioMarcosPaz.security.service.UsuarioService;
import com.portfolio.PortfolioMarcosPaz.service.impl.LanguageImpl;
import com.portfolio.PortfolioMarcosPaz.service.impl.SkillImpl;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.GetUser;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@CrossOrigin(origins = {"http://localhost:4200" , "https://portfolio-2fdd4.web.app"})
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    SkillImpl skillService;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    LanguageMapper mapper;
    @Autowired
    LanguageImpl languageService;
    @Autowired
    JwtProvider jwtProvider;

     @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody SkillRequest request) {

         ResponseEntity<?> E = skillService.create(request);
         return new ResponseEntity(E.getBody(),E.getStatusCode()) ;
    }
    @GetMapping("/all")
    public ResponseEntity<List<SkillResponse>> all() {
            return new ResponseEntity(skillService.all(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @PathVariable Long id , @RequestBody SkillRequest request) {
            SkillResponse responseEntity = skillService.update(id,request);
            return new ResponseEntity(new Message("update"),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
            ResponseEntity entity=   skillService.delete(id);
            return new ResponseEntity<>(entity.getBody(),entity.getStatusCode());
    }






}
