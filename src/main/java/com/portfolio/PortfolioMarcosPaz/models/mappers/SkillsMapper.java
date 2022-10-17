package com.portfolio.PortfolioMarcosPaz.models.mappers;

import com.portfolio.PortfolioMarcosPaz.models.entity.Skill;
import com.portfolio.PortfolioMarcosPaz.models.request.SkillRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.SkillResponse;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SkillsMapper {
    public Skill dtoToEntity (SkillRequest request, Usuario usuario){
        Skill skill = new Skill();
        skill.setId(request.getId());
        skill.setNameSkill(request.getNameSkill());
        skill.setPointSkill(request.getPointSkill());
        skill.setImageSkillStack(request.getImageSkillStack());
        skill.setUsuario(usuario);
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
        skill.setNameSkill(request.getNameSkill());
        skill.setPointSkill(request.getPointSkill());
        skill.setImageSkillStack(request.getImageSkillStack());
        return skill;
    }
    public List<SkillResponse> list(List<Skill> skills){
        List<SkillResponse> listResponse = new ArrayList<>();
        skills.forEach( skill -> {
            listResponse.add(entityToDto(skill));});
        return  listResponse;
    }

}
