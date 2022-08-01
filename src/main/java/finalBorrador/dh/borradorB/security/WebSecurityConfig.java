package finalBorrador.dh.borradorB.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UsuarioService usuarioService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public WebSecurityConfig(UsuarioService usuarioService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/pacientes").hasRole("ADMIN")
                .antMatchers("/odontologos").hasRole("ADMIN")
                .antMatchers("/turnos").hasAnyRole("ADMIN", "USER")
                .antMatchers("/get_all_odontologo.html").hasRole("ADMIN")
                .antMatchers("/post_odontologo.html").hasRole("ADMIN")
                .antMatchers("/get_all_paciente.html").hasRole("ADMIN")
                .antMatchers("/post_paciente.html").hasRole("ADMIN")
                .antMatchers("/get_all_turno").hasRole("ADMIN")
                .antMatchers("/post_turno").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .and()
                .csrf().disable()
        ;
    }

}
