package com.portfolio.PortfolioMarcosPaz.service.interfaces;

import com.portfolio.PortfolioMarcosPaz.models.entity.Skill;
import com.portfolio.PortfolioMarcosPaz.models.request.SkillRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.SkillResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISkill  {

    ResponseEntity<?> create(SkillRequest request);
    SkillResponse update(Long id ,SkillRequest request);

     List<Skill> all();
    ResponseEntity<?> delete(Long id);
}
