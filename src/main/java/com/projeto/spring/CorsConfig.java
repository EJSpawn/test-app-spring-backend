package com.projeto.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.List;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*") // permite solicitações de qualquer origem
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .maxAge(3600);
  }

  @Bean
  public CorsFilter corsFilter() {
      final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      final CorsConfiguration config = new CorsConfiguration();
      config.setAllowedOrigins(List.of("*"));
      config.setAllowedHeaders(List.of("Origin", "Content-Type", "Accept"));
      config.setAllowedMethods(List.of("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
      source.registerCorsConfiguration("/**", config);
      return new CorsFilter(source);
  }

  @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.csrf(withDefaults()).cors(withDefaults()).
              httpBasic(withDefaults());
	return http.build();
}

}