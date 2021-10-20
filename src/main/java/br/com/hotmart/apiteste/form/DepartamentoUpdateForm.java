package br.com.hotmart.apiteste.form;

import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.repository.DepartamentoRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public class DepartamentoUpdateForm {
    @NotNull
    private String nome;

    @NotNull
    private int numero;

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
    public Departamento update(Long id, DepartamentoRepository departamentoRepository){
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if(departamento.isPresent()){
            Departamento departamento_save = departamento.get();
            departamento_save.setNome(nome);
            departamento_save.setNumero(numero);
            return departamento_save;
        }
        return null;
    }
}
