package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Skill;
import com.portfolio.PortfolioMarcosPaz.models.request.SkillRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.SkillResponse;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.ISkill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillImpl  implements ISkill {
    @Override
    public SkillResponse create(SkillRequest request) {
        return null;
    }
    @Override
    public SkillResponse update(Long id, SkillRequest request) {
        return null;
    }
    @Override
    public List<SkillResponse> all() {

         return null ;
    }
    @Override
    public Skill delete(Long id) {
        return null;
    }
}
