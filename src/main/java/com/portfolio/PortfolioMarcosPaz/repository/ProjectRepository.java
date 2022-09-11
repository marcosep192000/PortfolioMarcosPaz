package com.portfolio.PortfolioMarcosPaz.repository;

import com.portfolio.PortfolioMarcosPaz.models.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}