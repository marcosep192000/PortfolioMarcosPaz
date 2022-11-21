package com.portfolio.PortfolioMarcosPaz.security;


import com.portfolio.PortfolioMarcosPaz.security.jwt.JwtEntryPoint;
import com.portfolio.PortfolioMarcosPaz.security.jwt.JwtTokenFilter;
import com.portfolio.PortfolioMarcosPaz.security.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    //Devuelve el mensaje de no autorizado
    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }

    /**
     * Encripta el pasword
     * @return pasword ecriptado
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/auth/add").permitAll()
                .antMatchers("/auth/update").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/auth/all").permitAll()
                .antMatchers("/language/**").permitAll()
                //---------------------------------------------------------//
                .antMatchers("/education/update").permitAll()
                .antMatchers("/education/create").permitAll()
                .antMatchers("/education/find").permitAll()
                .antMatchers("/education/all").permitAll()
                .antMatchers("/education/delete").permitAll()
                .antMatchers("/education/**").permitAll()
                //---------------------------------------------------------//
                .antMatchers("/experience/update").permitAll()
                .antMatchers("/experience/create").permitAll()
                .antMatchers("/experience/find").permitAll()
                .antMatchers("/experience/all").permitAll()
                .antMatchers("/experience/delete").permitAll()
                .antMatchers("/experience/**").permitAll()
                //---------------------------------------------------------//
                .antMatchers("/project/**").permitAll()
                .antMatchers("/project/update").permitAll()
                .antMatchers("/project/create").permitAll()
                .antMatchers("/project/find").permitAll()
                .antMatchers("/project/all").permitAll()
                .antMatchers("/project/delete").permitAll()
                //---------------------------------------------------------//
                .antMatchers("/project/**").permitAll()
                .antMatchers("/skills/update").permitAll()
                .antMatchers("/skills/create").permitAll()
                .antMatchers("/skills/find").permitAll()
                .antMatchers("/skills/all").permitAll()
                .antMatchers("/skills/delete").permitAll()
                .antMatchers("/skills/**").permitAll()
                //---------------------------------------------------------//
                .antMatchers("/portfolio/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
