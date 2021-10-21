package br.com.hotmart.apiteste.form;

import br.com.hotmart.apiteste.dto.ProjetoDTO;
import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.model.Projeto;
import br.com.hotmart.apiteste.repository.DepartamentoRepository;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.Optional;

public class ProjetoForm {

    @NotNull
    private String nome;
    @NotNull
    private Departamento departamento;

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
