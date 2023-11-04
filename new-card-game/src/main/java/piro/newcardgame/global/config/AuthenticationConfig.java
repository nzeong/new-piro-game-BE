package piro.newcardgame.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AuthenticationConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .httpBasic(HttpBasicConfigurer::disable)
                .csrf(CsrfConfigurer::disable)
                .cors(Customizer.withDefaults())
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // jwt 사용하는 경우 쓴다
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/**").permitAll()
                                .requestMatchers("/login", "/join").permitAll()) // join, login은 언제나 가능
                .getOrBuild();
//                .exceptionHandling(authenticationManager -> authenticationManager
//                        .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
//                        .accessDeniedHandler(new CustomAccessDeniedHandler()))
//                .addFilterBefore(new JwtAuthenticationFilter(this.userDetailsService, this.jwtTokenResolver), UsernamePasswordAuthenticationFilter.class);
    }
}
