package com.portfolio.PortfolioMarcosPaz.service.interfaces;

import com.portfolio.PortfolioMarcosPaz.models.request.PersonRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.PersonResponse;

public interface IPerson {
    PersonResponse create(PersonRequest personRequest);
    PersonResponse update(PersonRequest personRequest);
    void delete(Long id);
    PersonResponse all ();


}
