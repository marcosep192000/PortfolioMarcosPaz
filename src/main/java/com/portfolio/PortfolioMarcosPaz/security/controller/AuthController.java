package com.portfolio.PortfolioMarcosPaz.security.controller;
import com.portfolio.PortfolioMarcosPaz.models.entity.Language;
import com.portfolio.PortfolioMarcosPaz.models.mappers.LanguageMapper;
import com.portfolio.PortfolioMarcosPaz.models.request.LanguageRequest;
import com.portfolio.PortfolioMarcosPaz.models.response.LanguageResponse;
import com.portfolio.PortfolioMarcosPaz.repository.LanguageRepository;
import com.portfolio.PortfolioMarcosPaz.security.dto.JwtDto;
import com.portfolio.PortfolioMarcosPaz.security.dto.LoginUsuario;
import com.portfolio.PortfolioMarcosPaz.security.dto.NuevoUsuario;
import com.portfolio.PortfolioMarcosPaz.security.entity.Rol;
import com.portfolio.PortfolioMarcosPaz.security.entity.Usuario;
import com.portfolio.PortfolioMarcosPaz.security.enums.RolNombre;
import com.portfolio.PortfolioMarcosPaz.security.jwt.JwtProvider;
import com.portfolio.PortfolioMarcosPaz.security.repository.UsuarioRepository;
import com.portfolio.PortfolioMarcosPaz.security.service.RolService;
import com.portfolio.PortfolioMarcosPaz.security.service.UsuarioService;
import com.portfolio.PortfolioMarcosPaz.service.impl.LanguageImpl;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.GetUser;
import com.portfolio.PortfolioMarcosPaz.util.exeptions.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")



@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    RolService rolService;
    @Autowired
    LanguageMapper mapper;
    @Autowired
    LanguageImpl languageService;
    @Autowired
    JwtProvider jwtProvider;
    @PostMapping("/add")
    public ResponseEntity<?> nuevoUsuario(@RequestBody NuevoUsuario nuevoUsuario,
                                          BindingResult bindingResult){
        if(usuarioService.existsByUsuario(nuevoUsuario.getNombreUsuario())){
            return new ResponseEntity<>(new Message("This name exist"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
            return new ResponseEntity<>(new Message("This mail exist"), HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = new Usuario(nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);

        return new ResponseEntity<>("Usuario creado", HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity("error", HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),
                                loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<Usuario> listar(){


        return usuarioRepository.findAll();
    }

    @GetMapping("/portfolio")
    public Usuario createPostGivenUser(Authentication authentication) {
         Usuario user=usuarioService.getByUsuario(authentication.getName()).orElseThrow();
            return user;
        }
}

































