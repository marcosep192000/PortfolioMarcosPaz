package com.portfolio.PortfolioMarcosPaz.security.controller;


import com.portfolio.PortfolioMarcosPaz.security.dto.LoginUserDto;
import com.portfolio.PortfolioMarcosPaz.security.dto.jwtDto;
import com.portfolio.PortfolioMarcosPaz.security.dto.newUserMainDto;
import com.portfolio.PortfolioMarcosPaz.security.entity.Role;
import com.portfolio.PortfolioMarcosPaz.security.entity.User;
import com.portfolio.PortfolioMarcosPaz.security.enums.RoleName;
import com.portfolio.PortfolioMarcosPaz.security.jwt.JwtProvider;
import com.portfolio.PortfolioMarcosPaz.security.service.RoleService;
import com.portfolio.PortfolioMarcosPaz.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService usuarioService;

    @Autowired
    RoleService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> nuevoUsuario(@RequestBody newUserMainDto newUser,
                                          BindingResult bindingResult){
        if(usuarioService.existName(newUser.getNameUser())){
            return new ResponseEntity<>("Ese nombre ya existe", HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existEmail(newUser.getEmail())){
            return new ResponseEntity<>("Ese email ya existe", HttpStatus.BAD_REQUEST);
        }

        User user = new User(newUser.getNameUser(),
                newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(rolService.findByRoleName(String.valueOf(RoleName.ROLE_USER)).get());
        if(newUser.getRoles().contains("admin"))
            roles.add(rolService.findByRoleName(String.valueOf(RoleName.ROLE_ADMIN)).get());
        user.setRoleSet(roles);

        usuarioService.save(user);

        return new ResponseEntity<>("Usuario creado", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<jwtDto> login(@RequestBody LoginUserDto loginUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity("Campos mal", HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginUsuario.getNameUser(),
                                loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        jwtDto JwtDto = new jwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<>(JwtDto, HttpStatus.OK);
    }
    @GetMapping("/listarUsuario")
    @ResponseBody
    public List<User> listar(){
        return usuarioService.us() ;
    }
}