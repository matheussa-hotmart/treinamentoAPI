package br.com.hotmart.apiteste.form;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class OrcamentoForm {

    @NotNull
    private BigDecimal valor;
    private Date dataInicio;
    private Date dataFim;

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
