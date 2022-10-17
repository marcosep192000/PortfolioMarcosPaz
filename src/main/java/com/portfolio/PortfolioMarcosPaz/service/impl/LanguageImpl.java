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
        GetUser user = new GetUser() ;
        Usuario usuario = usuarioRepository.findByNombreUsuario(user.getUsuario()).orElseThrow();
        System.out.println("estaaaaaaaa!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+ usuario.getIdUsuario());
        System.out.println("numero de usuario" + usuario.getIdUsuario());

        Language language = mapper.dtoToLanguage(request,usuario);
        repository.save(language);
        return new ResponseEntity( mapper.entityToDto(language) ,HttpStatus.ACCEPTED);

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

    @Override
    public void deletLanguage(Long id) {
          repository.deleteById(id);

    }


}
