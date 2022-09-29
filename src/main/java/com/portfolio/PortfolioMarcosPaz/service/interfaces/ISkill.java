package com.portfolio.PortfolioMarcosPaz.service.interfaces;

import com.portfolio.PortfolioMarcosPaz.models.entity.Skill;
import com.portfolio.PortfolioMarcosPaz.models.request.SkillRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.SkillResponse;

import java.util.List;

public interface ISkill  {

    SkillResponse create(SkillRequest request);
    SkillResponse update(Long id ,SkillRequest request);

     List<SkillResponse> all();
    Skill delete(Long id);
}
