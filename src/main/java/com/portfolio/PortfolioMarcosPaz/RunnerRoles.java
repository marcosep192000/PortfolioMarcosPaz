package com.portfolio.PortfolioMarcosPaz;

import com.portfolio.PortfolioMarcosPaz.security.entity.Rol;
import com.portfolio.PortfolioMarcosPaz.security.repository.RolRepository;
import com.portfolio.PortfolioMarcosPaz.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static com.portfolio.PortfolioMarcosPaz.security.enums.RolNombre.ROLE_ADMIN;

@Component
@ComponentScan
public class RunnerRoles  implements CommandLineRunner {


    @Autowired
    RolRepository rolService;

    @Override
    public void run(String... args) throws Exception {
       System.out.println("Insert MySQL");
            Rol r = new Rol(ROLE_ADMIN);
            Rol S = new Rol(ROLE_ADMIN);
        rolService.save(r);
        rolService.save(S);
        System.out.println("Fin insercion Base de datos");

    }
}
