package com.portfolio.PortfolioMarcosPaz.service.interfaces;

import com.portfolio.PortfolioMarcosPaz.models.entity.Education;
import com.portfolio.PortfolioMarcosPaz.models.request.EducationRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.EducationResponse;

import java.util.List;

public interface IEducation {
 EducationResponse  createEducation(EducationRequest request );
 EducationResponse uptdateEducation(Long id);
 EducationResponse deleteEducation(Long id);
List<Education> allEducation();

}
