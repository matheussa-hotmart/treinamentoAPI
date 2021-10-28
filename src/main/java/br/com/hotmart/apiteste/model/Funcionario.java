package br.com.hotmart.apiteste.model;

import br.com.hotmart.apiteste.form.FuncionarioForm;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "funcionario", schema = "empresa")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "dataNascimento")
    private Date dataNascimneto;
    @Column(name = "sexo")
    private char sexo;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @Column(name = "supervisor_id")
    private Long supervisor_id;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String cpf, Date dataNascimneto, char sexo, Endereco endereco, Long supervisor_id) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimneto = dataNascimneto;
        this.sexo = sexo;
        this.endereco = endereco;
        this.supervisor_id = supervisor_id;
    }

    public Funcionario(FuncionarioForm form){
        this.nome = form.getNome();
        this.cpf = form.getCpf();
        this.dataNascimneto = form.getDataNascimento();
        this.sexo = form.getSexo();
        this.endereco = form.getEndereco();
        this.supervisor_id = form.getSupervisor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimneto() {
        return dataNascimneto;
    }

    public void setDataNascimneto(Date dataNascimneto) {
        this.dataNascimneto = dataNascimneto;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long getSupervisor() {
        return supervisor_id;
    }

    public void setSupervisor(Long supervisor_id) {
        this.supervisor_id = supervisor_id;
    }
}
