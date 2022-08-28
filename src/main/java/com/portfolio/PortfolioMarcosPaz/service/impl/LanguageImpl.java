package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Language;
import com.portfolio.PortfolioMarcosPaz.models.mappers.LanguageMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.LanguageRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.LanguageResponse;
import com.portfolio.PortfolioMarcosPaz.repository.LanguageRepository;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.ILanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageImpl implements ILanguage {
    @Autowired
    LanguageMapper mapper ;
    @Autowired
    LanguageRepository repository;
    @Override
    public LanguageResponse save(LanguageRequest request) {
        Language language = mapper.dtoToLanguage(request);
        repository.save(language);
        return mapper.entityToDto(language) ;
    }

    @Override
    public LanguageResponse update(LanguageRequest request) {
        Optional<Language> lan = repository.findById(request.getId());
        Language languageNuevo =  mapper.UpdateLanguage(lan.get(),request);
        repository.save(languageNuevo);
        return mapper.entityToDto(languageNuevo);
    }

    @Override
    public List<Language> allLanguages() {

        List<Language> List= repository.findAll();
       return List;
    }


}
