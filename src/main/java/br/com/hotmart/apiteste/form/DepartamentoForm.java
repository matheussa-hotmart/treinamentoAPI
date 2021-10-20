package br.com.hotmart.apiteste.form;

import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.repository.DepartamentoRepository;

import javax.validation.constraints.NotNull;


public class DepartamentoForm {
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

    public Departamento converter() {
        return new Departamento(nome, numero);
    }
}
