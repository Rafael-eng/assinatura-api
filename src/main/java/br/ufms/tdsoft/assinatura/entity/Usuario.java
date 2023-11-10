package br.ufms.tdsoft.assinatura.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario() {
    }

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
