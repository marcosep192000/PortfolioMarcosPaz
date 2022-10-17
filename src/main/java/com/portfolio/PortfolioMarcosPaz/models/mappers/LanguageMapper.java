package com.portfolio.PortfolioMarcosPaz.models.mappers;
import com.portfolio.PortfolioMarcosPaz.models.entity.Language;
import com.portfolio.PortfolioMarcosPaz.models.request.LanguageRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.LanguageResponse;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class LanguageMapper {



    public LanguageResponse entityToDto(Language language){
        LanguageResponse response = new LanguageResponse();
        response.setLanguage(language.getLanguage());
        response.setLevelOral(language.getLevelOral());
        response.setLevelEscrito(language.getLevelEscrito());
        return response;
    }
    public Language dtoToLanguage(LanguageRequest languageRequest,Usuario usuario )
    {
        Language language = new Language();
        language.setId(languageRequest.getId());
        language.setLanguage(languageRequest.getLanguage());
        language.setLevelOral(languageRequest.getLevelOral());
        language.setLevelEscrito(languageRequest.getLevelEscrito());
language.setUsuario(usuario);
        return language;
    }
    public Language UpdateLanguage(Language language , LanguageRequest languageResponse)
    {

        language.setLanguage(languageResponse.getLanguage());
        language.setLevelOral(languageResponse.getLevelOral());
        language.setLevelEscrito(languageResponse.getLevelEscrito());


        return language;
    }
}
