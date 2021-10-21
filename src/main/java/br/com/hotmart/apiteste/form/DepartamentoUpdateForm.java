package br.com.hotmart.apiteste.form;

import javax.validation.constraints.NotNull;

public class DepartamentoUpdateForm {
    @NotNull
    private String nome;

    @NotNull
    private int numero;

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
