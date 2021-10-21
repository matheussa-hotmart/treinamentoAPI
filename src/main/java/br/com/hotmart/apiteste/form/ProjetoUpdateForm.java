package br.com.hotmart.apiteste.form;

import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.model.Projeto;
import br.com.hotmart.apiteste.repository.DepartamentoRepository;
import br.com.hotmart.apiteste.repository.ProjetoRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ProjetoUpdateForm {
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

    public Projeto update(Long id, ProjetoRepository projetoRepository, DepartamentoRepository departamentoRepository){
        Optional<Projeto> projeto = projetoRepository.findById(id);
        Projeto projeto_save = projeto.get();
        Optional<Departamento> departamento = departamentoRepository.findById(this.departamento.getId());
        //Passa para a variavel que será salva
        Departamento departamento_save = departamento.get();
        //Verifica se há algum objeto
        if(projeto.isPresent()) {
            if(departamento.isPresent()){
                projeto_save.setNome(this.nome);
                projeto_save.setDepartamento(departamento_save);
                return projeto_save;
            }
            //Departamento não encontrado, retorna null
            return null;
        }
        //Projeto não encontrado
        return null;
    }
}
