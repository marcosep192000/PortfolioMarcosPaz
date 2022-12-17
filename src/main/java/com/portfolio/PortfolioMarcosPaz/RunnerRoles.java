package com.portfolio.PortfolioMarcosPaz;

import com.portfolio.PortfolioMarcosPaz.security.entity.Rol;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import com.portfolio.PortfolioMarcosPaz.security.repository.RolRepository;
import com.portfolio.PortfolioMarcosPaz.security.service.RolService;
import com.portfolio.PortfolioMarcosPaz.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static com.portfolio.PortfolioMarcosPaz.security.enums.RolNombre.ROLE_ADMIN;
import static com.portfolio.PortfolioMarcosPaz.security.enums.RolNombre.ROLE_USER;

@Component
@ComponentScan
public class RunnerRoles  implements CommandLineRunner {

@Autowired
PasswordEncoder pass;
@Autowired
UsuarioService usuario;
    @Autowired
    RolRepository rolService;

    @Override
    public void run(String... args) throws Exception {
       System.out.println("Insert MySQL");
            Rol r = new Rol(ROLE_ADMIN);
            Rol S = new Rol(ROLE_ADMIN);
        rolService.save(r);
        rolService.save(S);
        System.out.println("Insert MySQL");
        Usuario u = new Usuario();
        u.setNombreUsuario("marcos");
        u.setPassword(pass.encode("hola123456"));
        u.setEmail("marcosep192000@hotmail.com");
        u.setPerfilPhotograpy("dsa");
        u.setStack("full stack jr");
        u.setLastName("Paz Goncheff");
        u.setState("chaco");
        u.setAboutMe("Desde muy peueño desarrolle pasion por la  tecnologia , el diseño y el desarrollo");
        u.setName("marcos");
        u.setProvince("Las Breñas ");


        usuario.save(u);
        System.out.println("Fin insercion Base de datos");

    }

}
