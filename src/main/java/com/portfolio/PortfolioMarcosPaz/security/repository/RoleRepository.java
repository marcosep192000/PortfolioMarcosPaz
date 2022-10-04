package com.portfolio.PortfolioMarcosPaz.security.repository;

import com.portfolio.PortfolioMarcosPaz.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}