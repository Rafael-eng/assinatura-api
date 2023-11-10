package br.ufms.tdsoft.assinatura.loader;

import br.ufms.tdsoft.assinatura.entity.Usuario;
import br.ufms.tdsoft.assinatura.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDataLoader implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository; // Suponha que UserRepository é sua classe de repositório para usuários


    @Override
    public void run(String... args) {
        Usuario user1 = new Usuario("Usuário mock");
        usuarioRepository.save(user1);
    }
}
