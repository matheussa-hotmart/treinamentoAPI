package br.com.hotmart.apiteste.dto;

import br.com.hotmart.apiteste.model.Orcamento;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OrcamentoDTO {
    private Long id;
    private BigDecimal valor;
    private Date dataInicio;
    private Date dataFim;

    public OrcamentoDTO(Orcamento orcamento) {
        this.id = orcamento.getId();
        this.valor = orcamento.getValor();
        this.dataInicio = orcamento.getDataInicio();
        this.dataFim = orcamento.getDataFim();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public static List<OrcamentoDTO> converter(List<Orcamento> orcamentos){
        return orcamentos.stream().map(OrcamentoDTO::new).collect(Collectors.toList());
    }
}
