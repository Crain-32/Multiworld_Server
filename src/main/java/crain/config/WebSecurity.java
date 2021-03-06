package crain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Value("${admin.ip.address")
    private String adminIpAddress;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/app/**")
                .permitAll();
        http.authorizeRequests()
                .antMatchers("/topic/**")
                .permitAll();
        http.authorizeRequests()
                .antMatchers("/rest/**")
                .permitAll();
//                .hasIpAddress(adminIpAddress);
        http.csrf().disable();
    }
}
