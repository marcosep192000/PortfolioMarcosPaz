package com.portfolio.PortfolioMarcosPaz.security.repository;


import com.portfolio.PortfolioMarcosPaz.security.entity.Rol;
import com.portfolio.PortfolioMarcosPaz.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}