package br.com.hotmart.apiteste.model;

import br.com.hotmart.apiteste.form.OrcamentoForm;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orcamento", schema = "empresa")
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "valor")
    private float valor;
    @Column(name = "dataInicio")
    private Date dataInicio;
    @Column(name = "dataFim")
    private Date dataFim;

    public Orcamento() {
    }

    public Orcamento(Long id, float valor, Date dataInicio, Date dataFim) {
        this.id = id;
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Orcamento(OrcamentoForm form) {
        this.valor = form.getValor();
        this.dataInicio = form.getDataInicio();
        this.dataFim = form.getDataFim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
