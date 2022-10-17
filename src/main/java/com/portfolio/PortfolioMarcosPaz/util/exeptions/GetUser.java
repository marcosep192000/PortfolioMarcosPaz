package com.portfolio.PortfolioMarcosPaz.util.exeptions;

import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import com.portfolio.PortfolioMarcosPaz.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetUser {

    @Autowired
    UsuarioService usuarioService;

    public String getUsuario() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
        userDetails = (UserDetails) principal;}
    String userName = userDetails.getUsername();
        return userName;}
}
