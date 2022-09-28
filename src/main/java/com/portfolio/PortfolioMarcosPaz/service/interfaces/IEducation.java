package com.portfolio.PortfolioMarcosPaz.service.interfaces;

import com.portfolio.PortfolioMarcosPaz.models.entity.Education;
import com.portfolio.PortfolioMarcosPaz.models.request.EducationRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.EducationResponse;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;

import java.util.List;

public interface IEducation {
 EducationResponse  createEducation(EducationRequest request );
 EducationResponse uptdateEducation(Long id,EducationRequest request);
Message deleteEducation(Long id);
List<Education> allEducation();

}
