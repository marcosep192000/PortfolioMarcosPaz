package com.portfolio.PortfolioMarcosPaz.security.repository;

import com.portfolio.PortfolioMarcosPaz.security.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.transform.sax.SAXResult;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String nameUser);
 boolean existsByNameUser(String nameUser);
 boolean existByEmail(String mail);

}
