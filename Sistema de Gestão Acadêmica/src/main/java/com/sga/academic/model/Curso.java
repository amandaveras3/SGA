package com.sga.academic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "curso", uniqueConstraints = {
        @UniqueConstraint(columnNames = "sigla")
})
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String sigla;

    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // ✅ ADICIONADO
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}