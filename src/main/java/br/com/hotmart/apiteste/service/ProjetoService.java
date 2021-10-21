package br.com.hotmart.apiteste.service;

import br.com.hotmart.apiteste.form.DepartamentoForm;
import br.com.hotmart.apiteste.form.DepartamentoUpdateForm;
import br.com.hotmart.apiteste.form.ProjetoForm;
import br.com.hotmart.apiteste.form.ProjetoUpdateForm;
import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.model.Projeto;
import br.com.hotmart.apiteste.repository.DepartamentoRepository;
import br.com.hotmart.apiteste.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjetoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto createProjeto(ProjetoForm form){
        Optional<Departamento> departamento = departamentoRepository.findById(form.getDepartamento().getId());
        Departamento departamento_save = departamento.get();
        form.setDepartamento(departamento_save);
        //cria projeto para ser salvo através do form passado
        Projeto projeto = new Projeto(form);
        //Verificação de busca de departamento
        System.out.println(departamento);
        if(projeto.getDepartamento() != null){
            //salva
            projetoRepository.save(projeto);
            //retorna o projeto adicionado
            return projeto;
        }
        //Retorna null quando não acha o departamento
        return null;
    }

    public Projeto getOneProjeto(Long id){
        //Cria projeto opcional, pois pode ter ou não ter projeto
        Optional<Projeto> projeto = projetoRepository.findById(id);
        //Faz passagem para uma variavel de tipo Projeto(não opcional)
        Projeto projeto_save = projeto.get();
        //Verifica se tem algum objeto no projeto
        if(projeto.isPresent()){
            //Retorna o save, por causa do tipo (não pode ser opcional)
            return projeto_save;
        }
        // retorna nulo caso não haja projeto no BD com o id passado
        return null;
    }

    public Projeto updateProjeto(Long id, ProjetoUpdateForm form){
        Optional<Projeto> projeto = projetoRepository.findById(id);
        Projeto projeto_save = projeto.get();
        Optional<Departamento> departamento = departamentoRepository.findById(form.getDepartamento().getId());
        //Passa para a variavel que será salva
        Departamento departamento_save = departamento.get();
        //Verifica se há algum objeto em projeto
        if(projeto.isPresent()) {
            //Verficia se há algum objeto em departamento
            if(departamento.isPresent()){
                // substitui informação de nome
                projeto_save.setNome(form.getNome());
                //Substitui informação de departamento
                projeto_save.setDepartamento(departamento_save);
                //Retorna projeto salvo no bd
                return projeto_save;
            }
            //Departamento não encontrado, retorna null
            return null;
        }
        //Projeto não encontrado
        return null;
    }

    public Projeto safeDeleteProjeto(Long id){
        //Pesquisa para ver se há um projeto com o id repassado
        Optional<Projeto> projeto = projetoRepository.findById(id);
        Projeto projeto_save = projeto.get();
        //Verificação de id
        if(projeto != null){
            //Retorna o projeto apagado do BD
            return projeto_save;
        }
        //Caso não ache o projeto com o id passado, ele retorna null
        return	null;
    }

}
