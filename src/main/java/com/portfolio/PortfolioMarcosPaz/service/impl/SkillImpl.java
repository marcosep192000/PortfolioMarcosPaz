package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Skill;
import com.portfolio.PortfolioMarcosPaz.models.mappers.SkillsMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.SkillRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.SkillResponse;
import com.portfolio.PortfolioMarcosPaz.security.service.repository.SkillRepository;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.ISkill;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillImpl  implements ISkill {
    @Autowired
    SkillsMapper mapper;
    @Autowired
    SkillRepository repository ;

    //agregar foto de framework

    @ Override
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
        Skill skill = repository.findById(id).orElseThrow();
        Skill response =   mapper.update(skill,request);
        repository.save(response);
        return mapper.entityToDto(response);
    }
    @Override
    public List<Skill> all() {
        List<Skill>  response = repository.findAll();
        return response  ;}
    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Skill> skill = repository.findById(id);
        if (skill.isEmpty()) {
            return new ResponseEntity<>(new Message("Skill Not exist"), HttpStatus.ACCEPTED);}
        repository.deleteById(skill.get().getId());
        return new ResponseEntity<>(new Message("Skill deleted"), HttpStatus.ACCEPTED);
    }
}
