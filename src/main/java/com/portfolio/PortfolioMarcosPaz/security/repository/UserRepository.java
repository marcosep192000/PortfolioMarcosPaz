package com.portfolio.PortfolioMarcosPaz.security.repository;

import com.portfolio.PortfolioMarcosPaz.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}