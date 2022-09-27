package com.portfolio.PortfolioMarcosPaz.service.interfaces;

import com.portfolio.PortfolioMarcosPaz.models.entity.Education;
import com.portfolio.PortfolioMarcosPaz.models.request.EducationRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.EducationResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface IEducation {
 EducationResponse  createEducation(EducationRequest request );
 EducationResponse uptdateEducation(Long id);
 EducationResponse deleteEducation(Long id);
void allExperience();

}
