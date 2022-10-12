package com.portfolio.PortfolioMarcosPaz.service.impl;

import com.portfolio.PortfolioMarcosPaz.models.entity.Person;
import com.portfolio.PortfolioMarcosPaz.models.mappers.PersonMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.PersonRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.PersonResponse;
import com.portfolio.PortfolioMarcosPaz.repository.PersonRepository;
import com.portfolio.PortfolioMarcosPaz.service.interfaces.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonImp implements IPerson {
@Autowired
    PersonRepository personRepository;
@Autowired
    PersonMapper mapper;
    @Override
    public PersonResponse create(PersonRequest personRequest) {
        Person person = mapper.dtoToEntity(personRequest);
        personRepository.save(person);
    return mapper.entityToDto(person);
    }

    @Override
    public PersonResponse update(PersonRequest personRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Person> all() {
    List<Person> response=personRepository.findAll();

        return response ;
    }
}
