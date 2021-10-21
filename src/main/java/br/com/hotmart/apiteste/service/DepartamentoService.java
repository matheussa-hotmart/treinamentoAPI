package br.com.hotmart.apiteste.service;

import br.com.hotmart.apiteste.form.DepartamentoForm;
import br.com.hotmart.apiteste.form.DepartamentoUpdateForm;
import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento createDepartamento(DepartamentoForm form){
        Departamento departamento_save = new Departamento(form);
        departamentoRepository.save(departamento_save);
        return departamento_save;
    }

    public Departamento getOneDepartamento(Long id){
        //Cria departamento opcional, pois pode ter ou não ter departamento
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        //Faz passagem para uma variavel de tipo Departamento(não opcional)
        Departamento departamento_save = departamento.get();
        //Verifica se tem algum objeto no departamento
        if(departamento.isPresent()){
            //Retorna o save, por causa do tipo (não pode ser opcional)
            return departamento_save;
        }
        // retorna nulo caso não haja departamento no BD com o id passado
        return null;
    }

    public Departamento updateDepartamento(Long id, DepartamentoUpdateForm form){
        //Pesquisa departamento por id
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        //Verifica se há um objeto
        if(departamento.isPresent()){
            //Salvar dados na variavel departamento save
            Departamento departamento_save = departamento.get();
            //Substitui informações que vem do formulário
            departamento_save.setNome(form.getNome());
            departamento_save.setNumero(form.getNumero());
            //Retorno de departamento
            return departamento_save;
        }
        //Retorna null pois não acho id
        return null;
    }
    public Departamento safeDeleteDepartamento(Long id){
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        Departamento departamento_save = departamento.get();
        if(departamento != null){
            return departamento_save;
        }
        return	null;
    }


}
