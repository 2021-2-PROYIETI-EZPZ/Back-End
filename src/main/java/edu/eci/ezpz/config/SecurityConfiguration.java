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
                /*Security configuration Client*/
                .antMatchers(HttpMethod.GET,"/v1/client" ).hasRole("CLIENT")
                .antMatchers(HttpMethod.POST,"/v1/client" ).hasRole("CLIENT")
                .antMatchers(HttpMethod.PUT,"/v1/client/" ).hasRole("CLIENT")
                .antMatchers(HttpMethod.DELETE,"/v1/client/" ).hasRole("CLIENT")
                /*Security configuration Seller*/
                .antMatchers(HttpMethod.GET,"/v1/seller" ).hasRole("SELLER")
                .antMatchers(HttpMethod.POST,"/v1/seller" ).hasRole("SELLER")
                .antMatchers(HttpMethod.PUT,"/v1/seller/" ).hasRole("SELLER")
                .antMatchers(HttpMethod.DELETE,"/v1/seller" ).hasRole("SELLER")
                /*Security configuration Administrator - Membership*/
                .antMatchers(HttpMethod.GET,"/v1/membership" ).hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/v1/membership/" ).hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/v1/membership" ).hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/v1/membership/" ).hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/v1/membership/" ).hasRole("ADMIN")
                /*Security configuration Administrator*/
                .antMatchers(HttpMethod.GET,"/v1/admin" ).hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/v1/admin/" ).hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/v1/admin" ).hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/v1/admin/" ).hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/v1/admin/" ).hasRole("ADMIN")
                .anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(
                SessionCreationPolicy.STATELESS );
    }
}