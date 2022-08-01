package finalBorrador.dh.borradorB.security;

import finalBorrador.dh.borradorB.entities.Usuario;
import finalBorrador.dh.borradorB.entities.UsuarioRol;
import finalBorrador.dh.borradorB.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String hash=passwordEncoder.encode("hev");
        Usuario usuarioUno=new Usuario("Hernan","hev","hernan@gmail.com",
                hash, UsuarioRol.ROLE_USER);
        usuarioRepository.save(usuarioUno);

        BCryptPasswordEncoder passwordEncoderDos=new BCryptPasswordEncoder();
        String hashDos=passwordEncoder.encode("szb");
        Usuario usuarioDos=new Usuario("Silvina","szb","silvina@gmail.com",
                hashDos, UsuarioRol.ROLE_ADMIN);
        usuarioRepository.save(usuarioDos);
    }
}
