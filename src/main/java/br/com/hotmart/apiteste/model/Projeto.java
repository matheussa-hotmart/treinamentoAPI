package br.com.hotmart.apiteste.model;


import br.com.hotmart.apiteste.form.ProjetoForm;

import javax.persistence.*;

@Entity
@Table(name="projeto", schema = "empresa")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nome")
    private String nome;
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    public Projeto() {
    }

    public Projeto(ProjetoForm form){
        this.nome = form.getNome();
        this.departamento = form.getDepartamento();
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}

