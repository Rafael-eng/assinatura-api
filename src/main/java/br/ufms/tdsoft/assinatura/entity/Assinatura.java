package br.ufms.tdsoft.assinatura.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "ASSINATURA")
public class Assinatura {

    @Id
    @Column(name = "ID_PLANO_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PLANO", insertable = false, updatable = false)
    private Plano plano;

    @Column(name = "ID_PLANO")
    private Long idPlano;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @Column(name = "DATA_CONTRATACAO")
    private LocalDateTime dataContratacao;

    @Column(name = "DATA_VENCIMENTO")
    private LocalDateTime dataVencimento;

    @Column(name = "DATA_CANCELAMENTO")
    private LocalDateTime dataCancelamento;

    private transient long tempoRestante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(Long idPlano) {
        this.idPlano = idPlano;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDateTime dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public long getTempoRestante() {
        LocalDateTime agora = LocalDateTime.now();
        long diasRestantes = ChronoUnit.DAYS.between(agora, this.dataVencimento);
        return diasRestantes;
    }

    public LocalDateTime getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(LocalDateTime dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public void setTempoRestante(long tempoRestante) {
        this.tempoRestante = tempoRestante;
    }
}
