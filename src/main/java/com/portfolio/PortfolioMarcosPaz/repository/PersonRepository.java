package com.portfolio.PortfolioMarcosPaz.repository;

import com.portfolio.PortfolioMarcosPaz.models.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}