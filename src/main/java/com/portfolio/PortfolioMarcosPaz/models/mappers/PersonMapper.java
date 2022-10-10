package com.portfolio.PortfolioMarcosPaz.models.mappers;

import com.portfolio.PortfolioMarcosPaz.models.entity.Person;
import com.portfolio.PortfolioMarcosPaz.models.request.PersonRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.PersonResponse;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
public PersonResponse entityToDto(Person person)
{
    PersonResponse response =  new PersonResponse();
   response.setName(person.getName());
   response.setLastName(person.getLastName());
   response.setPerfilPhotograpy(person.getPerfilPhotograpy());
   response.setDirection(person.getDirection());
   response.setState(person.getState());
   response.setProvince(person.getProvince());
   response.setMail(person.getMail());
   response.setStack(person.getStack());
   response.setAboutMe(person.getAboutMe());

return response;
}
    public Person dtoToEntity(PersonRequest request)
    {
        Person person =  new Person();
        person.setName(request.getName());
        person.setLastName(request.getLastName());
        person.setPerfilPhotograpy(request.getPerfilPhotography());
        person.setDirection(request.getDirection());
        person.setState(request.getState());
        person.setProvince(request.getProvince());
        person.setMail(request.getMail());
        person.setStack(request.getStack());
        person.setAboutMe(request.getAboutMe());

        return person;
    }
}
