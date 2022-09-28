package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Education;
import com.portfolio.PortfolioMarcosPaz.models.mappers.EducationMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.EducationRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.EducationResponse;
import com.portfolio.PortfolioMarcosPaz.repository.EducationRepository;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.IEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public EducationResponse deleteEducation(Long id) {
        return null;
    }

    @Override
    public List<Education> allEducation() {
        return educationRepository.findAll();
    }
}
