package acc.br.desafio4.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  // Desabilitar CSRF
            .authorizeRequests()
                .requestMatchers("/", "/alunos/**", "/login", "/usuario/cadastrar", "/h2-console/**").permitAll()  // Permitir acesso a esses endpoints
                .anyRequest().authenticated(); // Requer autenticação para outros endpoints

        // Configuração específica para acesso ao H2 Console
        http.headers().frameOptions().disable(); // Permitir iframe para H2 Console

        return http.build();
    }
}
