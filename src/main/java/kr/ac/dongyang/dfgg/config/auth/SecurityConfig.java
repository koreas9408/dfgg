package kr.ac.dongyang.dfgg.config.auth;

import kr.ac.dongyang.dfgg.member.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/js/**", "/images/**", "/member/**").permitAll()
                .antMatchers("/board/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedPage("/error403")
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}
