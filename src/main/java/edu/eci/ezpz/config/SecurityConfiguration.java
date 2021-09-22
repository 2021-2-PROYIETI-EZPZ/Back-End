package edu.eci.ezpz.config;

import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    JwtRequestFilter jwtRequestFilter;

    public SecurityConfiguration(@Autowired JwtRequestFilter jwtRequestFilter)
    {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception
    {
        http.addFilterBefore( jwtRequestFilter, BasicAuthenticationFilter.class ).cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/v1/health").permitAll()
                .antMatchers(HttpMethod.POST, "/v1/auth" ).permitAll()
                .antMatchers(HttpMethod.POST,"/newProduct" ).hasRole("SELLER")
                .antMatchers(HttpMethod.PUT,"/newProduct" ).hasRole("SELLER")
                .antMatchers(HttpMethod.DELETE,"/newProduct" ).hasRole("SELLER")
                .antMatchers(HttpMethod.POST,"/newSeller" ).hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/newSeller" ).hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/newSeller" ).hasRole("ADMIN")
                .anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(
                SessionCreationPolicy.STATELESS );
    }
}