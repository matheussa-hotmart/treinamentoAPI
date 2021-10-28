package br.com.hotmart.apiteste.model;

import br.com.hotmart.apiteste.form.FuncionarioProjetoForm;

import javax.persistence.*;

@Entity
@Table(name = "funcionario_projeto", schema = "empresa")
public class FuncionarioProjeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    public FuncionarioProjeto() {
    }

    public FuncionarioProjeto(FuncionarioProjetoForm form) {
        this.funcionario = form.getFuncionario();
        this.projeto = form.getProjeto();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
