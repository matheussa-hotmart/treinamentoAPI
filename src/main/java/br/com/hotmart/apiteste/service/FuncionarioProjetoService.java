package br.com.hotmart.apiteste.service;

import br.com.hotmart.apiteste.exceptions.EntityNotFoundException;
import br.com.hotmart.apiteste.form.FuncionarioProjetoForm;
import br.com.hotmart.apiteste.model.Funcionario;
import br.com.hotmart.apiteste.model.FuncionarioProjeto;
import br.com.hotmart.apiteste.model.Projeto;
import br.com.hotmart.apiteste.repository.FuncionarioProjetoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FuncionarioProjetoService {

    private final FuncionarioProjetoRepository funcionarioProjetoRepository;
    private final FuncionarioService funcionarioService;
    private final ProjetoService projetoService;
    private String why = "Funcionario_projeto not found with id: ";

    public List<FuncionarioProjeto> getAll(){
        return funcionarioProjetoRepository.findAll();
    }

    public FuncionarioProjeto getOne(Long id){
        return funcionarioProjetoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(why+id));
    }

    public FuncionarioProjeto create(FuncionarioProjetoForm form){
        Funcionario funcionario = funcionarioService.getOneFuncionario(form.getFuncionario().getId());
        Projeto projeto = projetoService.getOneProjeto(form.getProjeto().getId());
        form.setFuncionario(funcionario);
        form.setProjeto(projeto);
        FuncionarioProjeto funcionarioProjeto = new FuncionarioProjeto(form);
        funcionarioProjetoRepository.save(funcionarioProjeto);
        return funcionarioProjeto;
    }

    public FuncionarioProjeto safeDelete(Long id) {
        Optional<FuncionarioProjeto> funcionarioProjeto = funcionarioProjetoRepository.findById(id);
        if(funcionarioProjeto.isPresent()){
            funcionarioProjetoRepository.deleteById(id);
            return funcionarioProjeto.get();
        }
        return funcionarioProjetoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(why+id));
    }

    public FuncionarioProjeto update(Long id, FuncionarioProjetoForm form) {
        Optional<FuncionarioProjeto> funcionarioProjeto = funcionarioProjetoRepository.findById(id);
        if(funcionarioProjeto.isPresent()){
            Funcionario funcionario = funcionarioService.getOneFuncionario(form.getFuncionario().getId());
            Projeto projeto = projetoService.getOneProjeto(form.getProjeto().getId());
            funcionarioProjeto.get().setFuncionario(funcionario);
            funcionarioProjeto.get().setProjeto(projeto);
            funcionarioProjetoRepository.save(funcionarioProjeto.get());
            return funcionarioProjeto.get();
        }
        return funcionarioProjetoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(why+id));
    }
}
