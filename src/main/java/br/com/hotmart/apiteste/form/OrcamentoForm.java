package br.com.hotmart.apiteste.form;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class OrcamentoForm {

    @NotNull
    private float valor;
    @NotNull
    private Date dataInicio;
    @NotNull
    private Date dataFim;

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
