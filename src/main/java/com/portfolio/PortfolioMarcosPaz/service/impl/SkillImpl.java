package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Skill;
import com.portfolio.PortfolioMarcosPaz.models.mappers.SkillsMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.SkillRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.SkillResponse;
import com.portfolio.PortfolioMarcosPaz.repository.SkillRepository;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.ISkill;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillImpl  implements ISkill {
    @Autowired
    SkillsMapper mapper;
    @Autowired
    SkillRepository repository ;
    @Override
    public ResponseEntity<?> create(SkillRequest request) {
        try {
            Skill response = mapper.dtoToEntity(request);
            repository.save(response);
            return new ResponseEntity<>(new Message("created"),HttpStatus.CREATED);
        }
        catch( Exception e)
        {
            return new ResponseEntity<>(new Message("error"),HttpStatus.NO_CONTENT);
        }
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
