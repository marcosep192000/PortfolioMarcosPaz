package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Skill;
import com.portfolio.PortfolioMarcosPaz.models.mappers.SkillsMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.SkillRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.SkillResponse;
import com.portfolio.PortfolioMarcosPaz.repository.SkillRepository;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import com.portfolio.PortfolioMarcosPaz.security.service.UsuarioService;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.ISkill;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.GetUser;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillImpl  implements ISkill {
    @Autowired
    SkillsMapper mapper;
    @Autowired
    SkillRepository repository ;
    @Autowired
    UsuarioService usuarioService;

    //agregar foto de framework

    @ Override
    public ResponseEntity<?> create(SkillRequest request) {
        try {
        GetUser user = new GetUser() ;
        Usuario usuario = usuarioService.getByUsuario(user.getUsuario());
        Skill response = mapper.dtoToEntity(request,usuario);
        repository.save(response);
        return new ResponseEntity<>(new Message("Create NEW Skill"),HttpStatus.CREATED);}
        catch( Exception e)
        {return new ResponseEntity<>(new Message("Error!"),HttpStatus.NO_CONTENT);}
    }

    @Override
    public SkillResponse update(Long id, SkillRequest request) {
        Skill skill = repository.findById(id)  .orElseThrow(() -> new IllegalStateException("No worker nodes"));
        Skill response =   mapper.update(skill,request);
        repository.save(response);
        return mapper.entityToDto(response);
    }
    @Override
    public List<Skill> all() {
        List<Skill>  response = repository.findAll();
        return response;}


    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Skill> skill = repository.findById(id);
        if (skill.isPresent()) {
        repository.deleteById(skill.get().getId());
            return new ResponseEntity<>(new Message("Skill deleted"), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(new Message("Skill Not exist"), HttpStatus.ACCEPTED);
    }
}
