package br.com.hotmart.apiteste.service;

import br.com.hotmart.apiteste.exceptions.EntityNotFoundException;
import br.com.hotmart.apiteste.form.ProjetoForm;
import br.com.hotmart.apiteste.form.ProjetoUpdateForm;
import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.model.Projeto;
import br.com.hotmart.apiteste.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final DepartamentoService departamentoService;
    private String why = "Projeto not found with id: ";

    public Projeto createProjeto(ProjetoForm form){
        Departamento departamento = departamentoService.getOneDepartamento(form.getDepartamento().getId());
        form.setDepartamento(departamento);
        //cria projeto para ser salvo através do form passado
        Projeto projeto = new Projeto(form);
        //salva
        projetoRepository.save(projeto);
        //retorna o projeto adicionado
        return projeto;
    }

    public Projeto getOneProjeto(Long id){
        return projetoRepository.findById(id).orElseThrow( () -> new EntityNotFoundException(why+id));
    }

    public Projeto updateProjeto(Long id, ProjetoUpdateForm form){
        Optional<Projeto> projeto = projetoRepository.findById(id);
        Departamento departamento = departamentoService.getOneDepartamento(form.getDepartamento().getId());
        //Verifica se há algum objeto em projeto
        if(projeto.isPresent()) {
            Projeto projeto_save = projeto.get();
            //Verficia se há algum objeto em departamento
            projeto_save.setNome(form.getNome());
            //Substitui informação de departamento
            projeto_save.setDepartamento(departamento);
            //Retorna projeto salvo no bd
            return projeto_save;
        }
        //Projeto não encontrado
        return projetoRepository.findById(id).orElseThrow( () -> new EntityNotFoundException(why+id));
    }

    public Projeto safeDeleteProjeto(Long id){
        //Pesquisa para ver se há um projeto com o id repassado
        Optional<Projeto> projeto = projetoRepository.findById(id);
        Projeto projeto_save = projeto.get();
        //Verificação de id
        if(projeto != null){
            projetoRepository.deleteById(id);
            //Retorna o projeto apagado do BD
            return projeto_save;
        }
        //Caso não ache o projeto com o id passado, ele retorna null
        return	projetoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(why+id));
    }

}
