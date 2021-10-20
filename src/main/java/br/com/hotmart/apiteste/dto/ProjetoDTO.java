package br.com.hotmart.apiteste.dto;

import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.model.Projeto;

import java.util.List;
import java.util.stream.Collectors;

public class ProjetoDTO {
    private Long projetoId;
    private String nome;
    private Departamento departamento;

    public ProjetoDTO(Projeto projeto) {
        this.projetoId = projeto.getId();
        this.nome = projeto.getNome();
        this.departamento = projeto.getDepartamento();
    }

    public Long getProjetoId() {
        return projetoId;
    }

    public String getNome() {
        return nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }


    public static List<ProjetoDTO> converter(List<Projeto> projetos) {
        //Conversão na mão seria set para pessoa e com get do dto
        return projetos.stream().map(ProjetoDTO::new).collect(Collectors.toList());
    }
}
