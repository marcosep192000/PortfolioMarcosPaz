package com.portfolio.PortfolioMarcosPaz.security.repository;

import com.portfolio.PortfolioMarcosPaz.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNameUser(String nameUser);
 boolean existsByNameUser(String nameUser);
 boolean existsByEmail(String mail);

}
