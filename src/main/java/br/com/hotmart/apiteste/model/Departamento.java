package br.com.hotmart.apiteste.model;

import br.com.hotmart.apiteste.form.DepartamentoForm;
import br.com.hotmart.apiteste.form.OrcamentoForm;

import javax.persistence.*;

// Reconhecedor de entidade do meu BD
@Entity
@Table(name="departamento", schema = "empresa") //parametros da função, nome da tabela, nome do bd(schema)
public class Departamento {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="numero")
    private int numero;
    @ManyToOne
    @JoinColumn(name = "orcamento_id")
    private Orcamento orcamento;

    public Departamento() {
    }

    public Departamento(DepartamentoForm form) {
        this.nome = form.getNome();
        this.numero = form.getNumero();
        this.orcamento = form.getOrcamento();
    }

    public Long getId() {
        return id;
    }

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