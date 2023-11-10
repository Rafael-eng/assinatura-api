package br.ufms.tdsoft.assinatura.service;

import br.ufms.tdsoft.assinatura.dto.PlanoRequest;
import br.ufms.tdsoft.assinatura.entity.Plano;
import br.ufms.tdsoft.assinatura.entity.Usuario;
import br.ufms.tdsoft.assinatura.repository.PlanoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    @Transactional
    public Plano create(PlanoRequest request) {
        Plano plano = new Plano(request.valor(),
                request.servicos(),
                request.descricao(),
                request.validadeDias()
        );

        return planoRepository.save(plano);
    }

    @Transactional
    public Plano update(Long idPlano, PlanoRequest request) {
        Plano plano = planoRepository.findById(idPlano).orElseThrow(()
                -> new RuntimeException("Usuário nao encontrado"));        //Usuario logado

        if (request.descricao() != null)
            plano.setDescricao(request.descricao());
        if (request.servicos() != null)
            plano.setServicos(request.servicos());
        if (request.valor() != null)
            plano.setValor(request.valor());
        if (request.validadeDias() != null)
            plano.setValidadeDias(request.validadeDias());

        return planoRepository.save(plano);
    }

    @Transactional
    public void deleteById(Long id) {
        planoRepository.deleteById(id);
    }

    public List<Plano> findAll() {
        return planoRepository.findAll();
    }
}
