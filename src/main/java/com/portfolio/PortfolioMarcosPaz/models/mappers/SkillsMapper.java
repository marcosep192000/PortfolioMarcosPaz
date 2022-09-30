package com.portfolio.PortfolioMarcosPaz.models.mappers;

import com.portfolio.PortfolioMarcosPaz.models.entity.Skill;
import com.portfolio.PortfolioMarcosPaz.models.request.SkillRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.SkillResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SkillsMapper {
    public Skill dtoToEntity (SkillRequest request){
        Skill skill = new Skill();
        skill.setId(request.getId());
        skill.setNameSkill(request.getNameSkill());
        skill.setPointSkill(request.getPointSkill());
        skill.setImageSkillStack(request.getImageSkillStack());
        return  skill;
    }
    public SkillResponse entityToDto (Skill skill ){
        SkillResponse response = new SkillResponse();
        response.setId(skill.getId());
        response.setNameSkill(skill.getNameSkill());
        response.setPointSkill(skill.getPointSkill());
        response.setImageSkillStack(skill.getImageSkillStack());
        return response;
    }
    public Skill update(Skill skill, SkillRequest request){
        skill.setId(request.getId());
        skill.setNameSkill(request.getNameSkill());
        skill.setPointSkill(request.getPointSkill());
        skill.setImageSkillStack(request.getImageSkillStack());
        return skill;
    }
    public List<SkillResponse> list (){
        return null ;
    }

}