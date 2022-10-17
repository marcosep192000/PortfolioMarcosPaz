package com.portfolio.PortfolioMarcosPaz.service.interfaces;

import com.portfolio.PortfolioMarcosPaz.models.entity.Language;
import com.portfolio.PortfolioMarcosPaz.models.request.LanguageRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.LanguageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ILanguage {
    ResponseEntity<?> save(LanguageRequest request);
    LanguageResponse update(LanguageRequest request);
    List<Language> allLanguages();
    void deletLanguage(Long id);
}
