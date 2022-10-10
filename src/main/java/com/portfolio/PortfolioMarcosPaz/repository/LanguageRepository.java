package com.portfolio.PortfolioMarcosPaz.repository;

import com.portfolio.PortfolioMarcosPaz.models.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language, Long> {

}