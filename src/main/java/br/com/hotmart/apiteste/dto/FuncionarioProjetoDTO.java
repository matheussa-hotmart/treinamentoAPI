package br.com.hotmart.apiteste.dto;

import br.com.hotmart.apiteste.model.Funcionario;
import br.com.hotmart.apiteste.model.Projeto;
import br.com.hotmart.apiteste.model.FuncionarioProjeto;

import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioProjetoDTO {
    private Long id;
    private Funcionario funcionario;
    private Projeto projeto;

    public FuncionarioProjetoDTO(FuncionarioProjeto funcionarioProjeto) {
        this.id = funcionarioProjeto.getId();
        this.funcionario = funcionarioProjeto.getFuncionario();
        this.projeto = funcionarioProjeto.getProjeto();
    }

    public Long getId() {
        return id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public static List<FuncionarioProjetoDTO> converter (List<FuncionarioProjeto> funcionariosProjetos){
        return funcionariosProjetos.stream().map(FuncionarioProjetoDTO::new).collect(Collectors.toList());
    }
}
