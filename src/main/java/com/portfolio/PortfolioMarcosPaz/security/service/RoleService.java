package com.portfolio.PortfolioMarcosPaz.security.service;

import com.portfolio.PortfolioMarcosPaz.security.entity.Role;
import com.portfolio.PortfolioMarcosPaz.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    public Optional<Role> findByRoleName(String roleName)
    {
      return   roleRepository.findByRoleName(roleName);
    }
}
