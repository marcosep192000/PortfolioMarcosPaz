package com.portfolio.PortfolioMarcosPaz.security.service;

import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import com.portfolio.PortfolioMarcosPaz.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public Boolean existsByUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public Boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    public List<Usuario> us()
    {return usuarioRepository.findAll();
    }



}
