package com.portfolio.PortfolioMarcosPaz.security.service.repository;

import com.portfolio.PortfolioMarcosPaz.models.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}