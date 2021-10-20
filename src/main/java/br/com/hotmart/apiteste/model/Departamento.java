package br.com.hotmart.apiteste.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Reconhecedor de entidade do meu BD
@Entity @Table(name="departamento", schema = "empresa") //parametros da função, nome da tabela, nome do bd(schema)
public class Departamento {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="numero")
    private int numero;

    public Departamento() {
    }
    public Departamento(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long departamentoId) {
        this.id = departamentoId;
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

}