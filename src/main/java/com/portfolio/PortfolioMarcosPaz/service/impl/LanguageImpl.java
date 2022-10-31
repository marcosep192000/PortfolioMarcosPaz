package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Language;
import com.portfolio.PortfolioMarcosPaz.models.mappers.LanguageMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.LanguageRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.LanguageResponse;
import com.portfolio.PortfolioMarcosPaz.repository.LanguageRepository;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import com.portfolio.PortfolioMarcosPaz.security.repository.UsuarioRepository;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.ILanguage;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.GetUser;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageImpl implements ILanguage {
    @Autowired
    LanguageMapper mapper ;
    @Autowired
    LanguageRepository repository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<?> save(LanguageRequest request) {
      try {
          GetUser user = new GetUser() ;
          Usuario usuario = usuarioRepository.findByNombreUsuario(user.getUsuario()).orElseThrow();
          Language language = mapper.dtoToLanguage(request,usuario);
          repository.save(language);
          mapper.entityToDto(language);
          return new ResponseEntity(new Message("language create"),HttpStatus.ACCEPTED);
      }
      catch (Exception e )
      {
          return new ResponseEntity(new Message("bad request"),HttpStatus.BAD_REQUEST);
      }

    }

    @Override
    public LanguageResponse update(LanguageRequest request) {
        Optional<Language> lan = repository.findById(request.getId());
        Language languageNuevo =  mapper.UpdateLanguage(lan.get().getId(), request);
        repository.save(languageNuevo);
        return mapper.entityToDto(languageNuevo);
    }

    @Override
    public List<Language> allLanguages() {
        List<Language> List= repository.findAll();
       return List;
    }

    @Override
    public void deletLanguage(Long id) {
          repository.deleteById(id);

    }


}
