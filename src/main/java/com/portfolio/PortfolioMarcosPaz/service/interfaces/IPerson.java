package com.portfolio.PortfolioMarcosPaz.service.interfaces;

import com.portfolio.PortfolioMarcosPaz.models.entity.Person;
import com.portfolio.PortfolioMarcosPaz.models.request.PersonRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.PersonResponse;

import java.util.List;

public interface IPerson {
    PersonResponse create(PersonRequest personRequest);
    PersonResponse update(PersonRequest personRequest);
    void delete(Long id);
    List<Person> all ();


}
