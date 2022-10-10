package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.request.PersonRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.PersonResponse;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.IPerson;
import org.springframework.stereotype.Service;

@Service
public class PersonImp implements IPerson {

    @Override
    public PersonResponse create(PersonRequest personRequest) {
        return null;
    }

    @Override
    public PersonResponse update(PersonRequest personRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PersonResponse all() {
        return null;
    }
}
