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
                .authorizeRequests()
                .antMatchers("/", "/static/css/**", "/static/js/**", "/static/images/**", "/member/**").permitAll()
                .antMatchers("/board/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedPage("/error/error403")
                .and()
                .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}
