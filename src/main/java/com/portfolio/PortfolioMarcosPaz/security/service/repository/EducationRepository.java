package com.portfolio.PortfolioMarcosPaz.security.service.repository;

import com.portfolio.PortfolioMarcosPaz.models.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}