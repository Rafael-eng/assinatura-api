package br.ufms.tdsoft.assinatura.service;

import br.ufms.tdsoft.assinatura.entity.Plano;
import br.ufms.tdsoft.assinatura.entity.Assinatura;
import br.ufms.tdsoft.assinatura.entity.Usuario;
import br.ufms.tdsoft.assinatura.repository.AssinaturaRepository;
import br.ufms.tdsoft.assinatura.repository.PlanoRepository;
import br.ufms.tdsoft.assinatura.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaRepository assinaturaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PlanoRepository planoRepository;

    public List<Assinatura> listAll(){
        return assinaturaRepository.findAll();
    }

    public Assinatura realizarAssinatura(Long idusuario, Long idPlano) {
        Usuario usuario = usuarioRepository.findById(idusuario).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        Plano plano = planoRepository.findById(idPlano).orElseThrow(() -> new RuntimeException("Plano nao encontrado"));

        if(assinaturaRepository.findAllByIdPlanoAndIdUsuario(idPlano, idusuario) != null
        && !assinaturaRepository.findAllByIdPlanoAndIdUsuario(idPlano, idusuario).isEmpty()){
            throw new RuntimeException("Usuário ja possui assinatura");
        }


        Assinatura assinatura = new Assinatura();
        assinatura.setIdUsuario(usuario.getId());
        assinatura.setIdPlano(plano.getId());
        assinatura.setAtivo(true);
        assinatura.setDataContratacao(LocalDateTime.now());
        assinatura.setDataVencimento(LocalDateTime.now().plusDays(plano.getValidadeDias()));

        return assinaturaRepository.save(assinatura);
    }

    public Assinatura cancelarAssinatura(Long idusuario, Long idPlano) {
        Usuario usuario = usuarioRepository.findById(idusuario).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        Plano plano = planoRepository.findById(idPlano).orElseThrow(() -> new RuntimeException("Plano nao encontrado"));


        Assinatura assinatura = assinaturaRepository.findAllByIdPlanoAndIdUsuario(plano.getId(), usuario.getId()).get(0);

        if (assinatura.getTempoRestante() >= 0 && assinatura.getAtivo()) {
            assinatura.setAtivo(false);
            assinatura.setDataCancelamento(LocalDateTime.now());
        }

        return assinaturaRepository.save(assinatura);
    }

    @Scheduled(cron = "0 0 * * * *")
    public void expirarAssinatura() {
        List<Assinatura> assinaturas = assinaturaRepository.
                findByAtivoIsTrueAndDataVencimentoIsLessThanEqual(LocalDateTime.now());

        for (Assinatura assinatura : assinaturas) {
            assinatura.setAtivo(false);
            assinatura.setDataCancelamento(LocalDateTime.now());
        }

        assinaturaRepository.saveAll(assinaturas);
    }

}
