package br.com.hotmart.apiteste.dto;

import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.model.Orcamento;

import java.util.List;
import java.util.stream.Collectors;

public class DepartamentoDTO {

    private Long id;
    private String nome;
    private int numero;
    private Orcamento orcamento;

    public DepartamentoDTO(Departamento departamento) {
        this.id = departamento.getId();
        this.nome = departamento.getNome();
        this.numero = departamento.getNumero();
        this.orcamento = departamento.getOrcamento();
    }


    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public int getNumero() {
        return numero;
    }
    public Orcamento getOrcamento(){return this.orcamento;}


    public static List<DepartamentoDTO> converter(List<Departamento> departamentos) {
        //Conversão na mão seria set para pessoa e com get do dto
        return departamentos.stream().map(DepartamentoDTO::new).collect(Collectors.toList());
    }
}
