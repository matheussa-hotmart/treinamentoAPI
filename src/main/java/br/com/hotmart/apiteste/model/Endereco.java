package br.com.hotmart.apiteste.model;

import br.com.hotmart.apiteste.form.EnderecoForm;

import javax.persistence.*;

@Entity
@Table(name = "endereco", schema = "empresa")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "pais")
    private String pais;
    @Column(name = "cep")
    private String cep;
    @Column(name = "uf")
    private String uf;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "rua")
    private String rua;

    public Endereco() {
    }
    public Endereco(EnderecoForm form) {
        this.pais = form.getPais();
        this.cep = form.getCep();
        this.uf = form.getUf();
        this.cidade = form.getCidade();
        this.rua = form.getRua();
    }

    public Long getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
