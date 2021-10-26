package br.com.hotmart.apiteste.form;

import javax.validation.constraints.NotNull;

public class EnderecoUpdateForm {
    @NotNull
    private String pais;

    @NotNull
    private String cep;

    @NotNull
    private String uf;

    @NotNull
    private String cidade;

    @NotNull
    private String rua;

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
