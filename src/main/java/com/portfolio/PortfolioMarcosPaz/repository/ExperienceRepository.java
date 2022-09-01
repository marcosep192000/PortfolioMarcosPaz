package com.portfolio.PortfolioMarcosPaz.repository;

import com.portfolio.PortfolioMarcosPaz.models.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}