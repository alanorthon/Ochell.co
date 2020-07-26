package co.ochell.jwtokensecurity.config;

import co.ochell.jwtokensecurity.security.jwt.JwtConfigurer;
import co.ochell.jwtokensecurity.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable() //Временно
                .csrf().disable() //Временно
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("").permitAll()
                .antMatchers("").hasRole("USER")
                .antMatchers("").hasRole("ADMIN")
                .anyRequest().authenticated()

                .and()
                .apply(new JwtConfigurer(jwtTokenProvider))

                .and()
                .formLogin()
                .loginPage("")
                .and()
                .logout()
                .logoutSuccessUrl("");
    }
}
