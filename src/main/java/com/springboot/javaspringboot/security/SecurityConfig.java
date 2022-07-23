package com.springboot.javaspringboot.security;

import com.springboot.javaspringboot.dao.CustomerDAO;
import com.springboot.javaspringboot.models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.stream.Collectors;

@Configuration
@EnableWebMvc
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private CustomerDAO customerDAO;
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

//        auth.userDetailsService(username -> {
//            Customer customer = customerDAO.findByLogin(username);
//            String password = customer.getPassword();
//            List<Authority> roles = customer.getRoles();
//            return new User(username, password, roles);
//        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
//                .antMatchers(HttpMethod.POST, "/").authenticated()
                .antMatchers(HttpMethod.POST, "/").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/customers").permitAll()
                .antMatchers("/customers").hasAnyRole("ADMIN", "MANAGER", "USER")
                .and()

                .httpBasic().and()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .cors().configurationSource(corsConfigurationSource()).and();

//                .addFilterBefore((servletRequest, servletResponse, filterChain) -> {
//                    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
//
//                    final String authorization = httpRequest.getHeader("Authorization");
//
//                    System.out.println(authorization);
//
//                    // Authorization: Basic base64credentials
//                    String base64Credentials = authorization.substring("Basic".length()).trim();
//                    byte[] credDecoder = Base64.getDecoder().decode(base64Credentials);
//                    String credentials = new String(credDecoder, StandardCharsets.UTF_8);
//                    // credentials = username:password
//                    final String[] values = credentials.split(":", 2);
//                    System.out.println(Arrays.toString(values));
//
//                    filterChain.doFilter(servletRequest, servletResponse);
//                }, UsernamePasswordAuthenticationFilter.class);

//                .addFilterBefore(new Filter() {
//                    @Override
//                    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//                        System.out.println("===Filter works===");
//
//                        filterChain.doFilter(servletRequest, servletResponse);
//                    }
//                }, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:3000"));
        configuration.addAllowedHeader("*");
        configuration.setAllowedMethods(Arrays.asList(
                HttpMethod.GET.name(),
                HttpMethod.HEAD.name(),
                HttpMethod.PATCH.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.DELETE.name()));
        configuration.addExposedHeader("Authorization");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }
}
