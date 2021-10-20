package br.com.hotmart.apiteste.dto;

import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.model.Projeto;

public class DetalhesProjetoDTO {
    private Long id;
    private String nome;
    private Departamento departamento;

    public DetalhesProjetoDTO(Projeto projeto) {
        this.id = projeto.getId();
        this.nome = projeto.getNome();
        this.departamento = projeto.getDepartamento();
    }

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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
