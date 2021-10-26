package br.com.hotmart.apiteste.form;

import br.com.hotmart.apiteste.model.Departamento;

import javax.validation.constraints.NotNull;

public class ProjetoForm {

    @NotNull
    private String nome;
    @NotNull
    private Departamento departamento;

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
