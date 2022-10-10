package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Education;
import com.portfolio.PortfolioMarcosPaz.models.mappers.EducationMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.EducationRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.EducationResponse;
import com.portfolio.PortfolioMarcosPaz.repository.EducationRepository;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.IEducation;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationImpl implements IEducation {

    @Autowired
    EducationRepository educationRepository;
    @Autowired
    EducationMapper mapper;
    @Override
    public EducationResponse createEducation(EducationRequest request) {
        Education response = mapper.dtoToEntity(request);
        educationRepository.save(response);
        return  mapper.entityToDto(response);
    }

    @Override
    public EducationResponse uptdateEducation(Long id,EducationRequest request) {
        Education education = educationRepository.findById(id).orElseThrow();
        Education upadateEducation = mapper.update(request,education);
        educationRepository.save(upadateEducation);
        return mapper.entityToDto(upadateEducation);
    }

    @Override
    public Message deleteEducation(Long id) {
     Optional<Education> education =  educationRepository.findById(id);
     if(education.isPresent()) {
         educationRepository.deleteById(education.get().getId());
         return new Message("deleted");
     }
       return  new Message("not exist");
    }
    @Override
    public List<Education> allEducation() {
        return educationRepository.findAll();
    }
}
