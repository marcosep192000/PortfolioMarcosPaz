package com.portfolio.PortfolioMarcosPaz.security.jwt;

import com.portfolio.PortfolioMarcosPaz.security.service.UserDetailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

   @Autowired
   JwtProvider jwtProvider;
@Autowired
    UserDetailServiceImpl userDetailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
try {
    String token = getToken(request);
    if (token != null && jwtProvider.validateToken(token))
    {
        String nameUser= jwtProvider.getNombreUsuarioFromToken(token);
        UserDetails userDetails = userDetailService.loadUserByUsername(nameUser);
        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

    }

}
catch (Exception e)
{
    logger.error("fail to method doFilter");
}
filterChain.doFilter(request,response);
    }


    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("bearer")) ;
        return header.replace("Bearer", "");

    }
}
