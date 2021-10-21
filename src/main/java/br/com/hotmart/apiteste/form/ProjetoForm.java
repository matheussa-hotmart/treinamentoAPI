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

    public Projeto converter(DepartamentoRepository departamentoRepository) {
        //Verificação para ver se o id de departamento passado no form é válido, ou seja, se há um departamento com o id passado
        Optional<Departamento> departamento = departamentoRepository.findById(this.departamento.getId());
        //Passa para a variavel que será salva
        Departamento departamento_save = departamento.get();
        //Verifica se há algum objeto
        if(departamento.isPresent()) {
            //Insere departamento na estrutura, departamento que veio do repositorio de departamentos
            return new Projeto(this.nome, departamento_save);
        }
        //retorna nulo caso não haja departamento com o id passado
       return null;
    }
}
