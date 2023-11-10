package br.ufms.tdsoft.assinatura.repository;

import br.ufms.tdsoft.assinatura.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
