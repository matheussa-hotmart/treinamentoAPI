package br.com.hotmart.apiteste.form;

import br.com.hotmart.apiteste.model.Funcionario;
import br.com.hotmart.apiteste.model.Projeto;

import javax.validation.constraints.NotNull;

public class FuncionarioProjetoForm {

    @NotNull
    private Funcionario funcionario;
    @NotNull
    private Projeto projeto;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
