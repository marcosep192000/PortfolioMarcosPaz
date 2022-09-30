package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Skill;
import com.portfolio.PortfolioMarcosPaz.models.request.SkillRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.SkillResponse;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.ISkill;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillImpl  implements ISkill {
    @Override
    public ResponseEntity<?> create(SkillRequest request) {

        if (request.getId()==1)
        return  new ResponseEntity<>(new Message("SERROR"), HttpStatus.GATEWAY_TIMEOUT);

        return new ResponseEntity<>(new Message(""),HttpStatus.CREATED);
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
