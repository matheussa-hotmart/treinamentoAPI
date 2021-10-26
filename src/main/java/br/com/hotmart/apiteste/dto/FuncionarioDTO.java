package br.com.hotmart.apiteste.dto;

import br.com.hotmart.apiteste.model.Endereco;
import br.com.hotmart.apiteste.model.Funcionario;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioDTO {
    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private char sexo;
    private Endereco endereco;
    private Long supervisor;

    public FuncionarioDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
        this.dataNascimento = funcionario.getDataNascimneto();
        this.sexo = funcionario.getSexo();
        this.endereco = funcionario.getEndereco();
        this.supervisor = funcionario.getSupervisor();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Long getSupervisor() {
        return supervisor;
    }

    public static List<FuncionarioDTO> converter(List<Funcionario> funcionarios){
        return funcionarios.stream().map(FuncionarioDTO::new).collect(Collectors.toList());
    }
}
