package br.com.hotmart.apiteste.service;

import br.com.hotmart.apiteste.exceptions.EntityNotFoundException;
import br.com.hotmart.apiteste.form.FuncionarioForm;
import br.com.hotmart.apiteste.model.Endereco;
import br.com.hotmart.apiteste.model.Funcionario;
import br.com.hotmart.apiteste.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final EnderecoService enderecoService;
    private String why = "Funcionario not found with id: ";

    public Funcionario createFuncionario(FuncionarioForm form){
        // guarda endereço buscando service, caso dê error exception lançada
        Endereco endereco = enderecoService.getOneEndereco(form.getEndereco().getId());
        // set de endereço completo após busca por id no bd
        form.setEndereco(endereco);
        //retorna novo funcionario;
        return new Funcionario(form);
    }

    public Funcionario getOneFuncionario(Long id){
        return funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(why+id));
    }


    public Funcionario updateFuncionario(Long id, FuncionarioForm form){
        Endereco endereco = enderecoService.getOneEndereco(form.getEndereco().getId());
        form.setEndereco(endereco);
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if(funcionario.isPresent()){
            funcionario.get().setCpf(form.getCpf());
            funcionario.get().setNome(form.getNome());
            funcionario.get().setDataNascimneto(form.getDataNascimento());
            funcionario.get().setSexo(form.getSexo());
            funcionario.get().setEndereco(form.getEndereco());
            funcionario.get().setSupervisor(funcionario.get().getSupervisor());
            funcionarioRepository.save(funcionario.get());
            return  funcionario.get();
        }
        return funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(why+id));
    }

    public Funcionario safeDeleteFuncionario(Long id){
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if(funcionario.isPresent()){
            funcionarioRepository.deleteById(id);
            return funcionario.get();
        }
        return funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(why+id));
    }
}
