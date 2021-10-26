package br.com.hotmart.apiteste.dto;

import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.model.Endereco;

public class DetalhesEnderecoDTO {
    private Long id;
    private String pais;
    private String uf;
    private String cidade;
    private String rua;
    private String cep;

    public DetalhesEnderecoDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.pais = endereco.getPais();
        this.uf = endereco.getUf();
        this.cidade = endereco.getCidade();
        this.rua = endereco.getRua();
        this.cep = endereco.getCep();
    }

    public Long getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public String getUf() {
        return uf;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getCep() {
        return cep;
    }
}
