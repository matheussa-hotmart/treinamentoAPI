package br.com.hotmart.apiteste.model;

import br.com.hotmart.apiteste.form.OrcamentoForm;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="orcamento", schema = "empresa")
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "dataInicio")
    private Date dataInicio;
    @Column(name = "dataFim")
    private Date dataFim;

    public Orcamento() {
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
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
