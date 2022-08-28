package com.portfolio.PortfolioMarcosPaz.models.response;

import lombok.*;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageResponse implements Serializable {
    private  String language;
    private  String levelEscrito;
    private  String levelOral;

}
