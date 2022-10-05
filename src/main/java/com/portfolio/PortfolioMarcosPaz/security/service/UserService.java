package com.portfolio.PortfolioMarcosPaz.security.service;

import com.portfolio.PortfolioMarcosPaz.security.entity.User;
import com.portfolio.PortfolioMarcosPaz.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Optional<User> findByNameUser(String name) {
        return userRepository.findByNameUser(name);
    }

    public boolean existEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existName(String name) {
        return userRepository.existsByNameUser(name);
    }
    public void  save(User user)
    {
        userRepository.save(user);
    }
    public List<User> us()
    {return userRepository.findAll();
    }

}