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
//con perPostEnabled se usa para indicar a q metodos puede acceder solo el admin
// Los metodos que no lleven anotación pueden acceder el admin como un generic user
// @preauthorized solo puede acceder el admin
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
                .antMatchers(HttpMethod.POST,"/auth/add").permitAll()
                .antMatchers(HttpMethod.POST,"/auth/update").permitAll()
                .antMatchers(HttpMethod.POST,"/auth/login").permitAll()
                .antMatchers(HttpMethod.GET,"/auth/all").permitAll()
                .antMatchers("/language/**").permitAll()
                //---------------------------------------------------------//
                .antMatchers(HttpMethod.PUT,"/education/update").permitAll()
                .antMatchers(HttpMethod.POST,"/education/create").permitAll()
                .antMatchers(HttpMethod.GET,"/education/find").permitAll()
                .antMatchers(HttpMethod.GET,"/education/all").permitAll()
                .antMatchers(HttpMethod.DELETE,"/education/delete").permitAll()
                .antMatchers(HttpMethod.POST,"/education/**").permitAll()
                //---------------------------------------------------------//
                .antMatchers(HttpMethod.PUT,"/experience/update").permitAll()
                .antMatchers(HttpMethod.POST,"/experience/create").permitAll()
                .antMatchers(HttpMethod.GET,"/experience/find").permitAll()
                .antMatchers(HttpMethod.GET,"/experience/all").permitAll()
                .antMatchers(HttpMethod.DELETE,"/experience/delete").permitAll()
                .antMatchers(HttpMethod.POST,"/experience/**").permitAll()
                //---------------------------------------------------------//
                .antMatchers("/project/**").permitAll()
                .antMatchers(HttpMethod.PUT,"/project/update").permitAll()
                .antMatchers(HttpMethod.POST,"/project/create").permitAll()
                .antMatchers(HttpMethod.GET,"/project/find").permitAll()
                .antMatchers(HttpMethod.GET,"/project/all").permitAll()
                .antMatchers(HttpMethod.DELETE,"/project/delete").permitAll()
                //---------------------------------------------------------//
                .antMatchers("/project/**").permitAll()
                .antMatchers(HttpMethod.PUT,"/skills/update").permitAll()
                .antMatchers(HttpMethod.POST,"/skills/create").permitAll()
                .antMatchers(HttpMethod.GET,"/skills/find").permitAll()
                .antMatchers(HttpMethod.GET,"/skills/all").permitAll()
                .antMatchers(HttpMethod.DELETE,"/skills/delete").permitAll()
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
