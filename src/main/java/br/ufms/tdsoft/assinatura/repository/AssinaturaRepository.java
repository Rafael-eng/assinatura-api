package br.ufms.tdsoft.assinatura.repository;

import br.ufms.tdsoft.assinatura.entity.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {

    List<Assinatura> findByAtivoIsTrueAndDataVencimentoIsLessThanEqual(LocalDateTime dataAtual);

    List<Assinatura> findAllByIdPlanoAndIdUsuario(Long idPlano, Long idUsuario);

}
