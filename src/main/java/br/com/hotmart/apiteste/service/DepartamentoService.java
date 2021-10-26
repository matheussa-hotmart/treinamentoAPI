package br.com.hotmart.apiteste.service;

import br.com.hotmart.apiteste.exceptions.EntityNotFoundException;
import br.com.hotmart.apiteste.form.DepartamentoForm;
import br.com.hotmart.apiteste.form.DepartamentoUpdateForm;
import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private String why = "Departamento not found with id: ";

    public Departamento createDepartamento(DepartamentoForm form){
        Departamento departamento = new Departamento(form);
        departamentoRepository.save(departamento);
        return departamento;
    }
    @SuppressWarnings("Unchecked")
    public Departamento getOneDepartamento(Long id){
        return departamentoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(why+id));
    }
    @SuppressWarnings("Unchecked")
    public Departamento updateDepartamento(Long id, DepartamentoUpdateForm form){
        //Pesquisa departamento por id
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if(departamento.isPresent()){
            Departamento departamento_save = departamento.get();
            //Substitui informações que vem do formulário
            departamento_save.setNome(form.getNome());
            departamento_save.setNumero(form.getNumero());
            //Retorno de departamento
            departamentoRepository.save(departamento_save);
            return  departamento_save;
        }
        return departamentoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(why+id));

    }

    public Departamento safeDeleteDepartamento(Long id){
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if(departamento.isPresent()){
            departamentoRepository.deleteById(id);
            return departamento.get();
        }
        return departamentoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(why+id));

    }


}
