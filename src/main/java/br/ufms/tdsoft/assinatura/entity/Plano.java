package br.ufms.tdsoft.assinatura.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "PLANO")
public class Plano {

    public Plano(BigDecimal valor, String descricao, String servicos, Long validadeDias) {
        this.valor = valor;
        this.descricao = descricao;
        this.servicos = servicos;
        this.validadeDias = validadeDias;
    }

    @Id
    @Column(name = "ID_PLANO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "VALOR", nullable = false)
    private BigDecimal valor;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "SERVICOS")
    private String servicos;

    @Column(name = "VALIDADE_DIAS")
    private Long validadeDias;

    public Plano() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getServicos() {
        return servicos;
    }

    public void setServicos(String servicos) {
        this.servicos = servicos;
    }

    public Long getValidadeDias() {
        return validadeDias;
    }

    public void setValidadeDias(Long validadeDias) {
        this.validadeDias = validadeDias;
    }

}
