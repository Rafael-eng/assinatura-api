package br.ufms.tdsoft.assinatura.repository;

import br.ufms.tdsoft.assinatura.entity.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {
}
