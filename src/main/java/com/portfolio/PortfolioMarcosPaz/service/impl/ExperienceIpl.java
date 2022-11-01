package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Experience;
import com.portfolio.PortfolioMarcosPaz.models.mappers.ExperienceMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.ExperienceRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.ExperienceResponse;
import com.portfolio.PortfolioMarcosPaz.repository.ExperienceRepository;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import com.portfolio.PortfolioMarcosPaz.security.repository.UsuarioRepository;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.IExperience;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.GetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienceIpl implements IExperience {
@Autowired
    ExperienceMapper mapper;
@Autowired
    UsuarioRepository usuarioRepository;
@Autowired
ExperienceRepository experienceService;
    @Override
    public ExperienceResponse saveExperience(ExperienceRequest request) {
        GetUser user = new GetUser();
        Usuario usuario = usuarioRepository.findByNombreUsuario(user.getUsuario());
        Experience experience = mapper.dtoToExperiencia(request,usuario);
        experienceService.save(experience);
        return mapper.experienceToDto(experience);
    }

    @Override
    public ExperienceResponse updateExperience(Long id , ExperienceRequest request) {
        Optional<Experience> experience = experienceService.findById(id);
       Experience experience1 =  mapper.updateExperience(experience.get(),request);
        experienceService.save(experience1);
        return mapper.experienceToDto(experience1);
    }
    @Override
    public List<Experience> allExperiences() {
        experienceService.findAll();
        List<Experience> newList = new ArrayList(experienceService.findAll());
        return  newList;
    }
    @Override
    public void deletExperience(Long id) {
        Optional<Experience> experience = experienceService.findById(id);
        Experience experience1;
        if (experience.get().getState(true)) {
            experience1 = mapper.UpdateSoftDelete(experience.get(),  false);}
        else  {experience1 = mapper.UpdateSoftDelete(experience.get(), true);}
        experienceService.save(experience1);
    }
}
