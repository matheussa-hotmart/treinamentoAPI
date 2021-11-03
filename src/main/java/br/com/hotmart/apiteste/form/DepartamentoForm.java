package br.com.hotmart.apiteste.form;

import br.com.hotmart.apiteste.model.Orcamento;

import javax.validation.constraints.NotNull;


public class DepartamentoForm {
    @NotNull
    private String nome;

    @NotNull
    private int numero;

    @NotNull
    private Orcamento orcamento;

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

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }
}
