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

    public Usuario getByUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public Optional<Usuario> findByID(Long id) {
        return usuarioRepository.findById(id);
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
    {return usuarioRepository.findAll();}

    //Recupera el user de la session .
    public Usuario userSess(Long id ){
        Usuario usuario = usuarioRepository.findById(id)  .orElseThrow(() -> new IllegalStateException("No worker nodes"));;
        return usuario;
}

    public Usuario update(Long id,Usuario usuario) {

        Usuario usuario1 = usuarioRepository.findById(id) .orElseThrow(() -> new IllegalStateException("No worker nodes"));
        System.out.print(usuario1);


        usuario1.setEmail(usuario.getEmail());
        usuario1.setAboutMe(usuario.getAboutMe());
        usuario1.setProvince(usuario.getProvince());
        usuario1.setState(usuario.getState());
        usuario1.setLastName(usuario.getLastName());
        usuario1.setPerfilPhotograpy(usuario.getPerfilPhotograpy());
        usuario1.setName(usuario.getName());
        usuario1.setStack(usuario.getStack());
        usuarioRepository.save(usuario1);

        return  usuario1 ;
    }
}
