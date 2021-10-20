package br.com.hotmart.apiteste.dto;


import br.com.hotmart.apiteste.model.Departamento;

import java.util.List;

public class DetalhesDepartamentoDTO {
    private Long id;
    private String nome;
    private int numero;

    public DetalhesDepartamentoDTO(Departamento departamento) {
        this.id = departamento.getId();
        this.nome = departamento.getNome();
        this.numero = departamento.getNumero();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long departamentoId) {
        this.id = departamentoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}

