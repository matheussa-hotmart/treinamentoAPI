package br.com.hotmart.apiteste.service;

import br.com.hotmart.apiteste.exceptions.EntityNotFoundException;
import br.com.hotmart.apiteste.form.DepartamentoForm;
import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.model.Funcionario;
import br.com.hotmart.apiteste.model.Orcamento;
import br.com.hotmart.apiteste.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final OrcamentoService orcamentoService;
    private String why = "Departamento not found with id: ";

    @SuppressWarnings("Unchecked")
    public Departamento createDepartamento(DepartamentoForm form){
        Orcamento orcamento = orcamentoService.getOne(form.getOrcamento().getId());
        form.setOrcamento(orcamento);
        Departamento departamento = new Departamento(form);
        departamentoRepository.save(departamento);
        return departamento;
    }
    @SuppressWarnings("Unchecked")
    public Departamento getOneDepartamento(Long id){
        return departamentoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(why+id));
    }
    @SuppressWarnings("Unchecked")
    public Departamento updateDepartamento(Long id, DepartamentoForm form){
        //Pesquisa departamento por id
        Orcamento orcamento = orcamentoService.getOne(form.getOrcamento().getId());
        form.setOrcamento(orcamento);
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if(departamento.isPresent()){
            departamento.get().setOrcamento(form.getOrcamento());
            departamento.get().setNumero(form.getNumero());
            departamento.get().setNome(form.getNome());
            departamentoRepository.save(departamento.get());
            return  departamento.get();
        }
        return departamentoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(why+id));

    }
    @SuppressWarnings("Unchecked")
    public Departamento safeDeleteDepartamento(Long id){
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if(departamento.isPresent()){
            departamentoRepository.deleteById(id);
            return departamento.get();
        }
        return departamentoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(why+id));

    }
    @SuppressWarnings("Unchecked")
    public List<Departamento> getAll(){
        return departamentoRepository.findAll();
    }


    public String statusOrcamento(Long id) {
        float total = 0;
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if(departamento.isPresent()){
            List<Funcionario> funcionarios = departamentoRepository.findSalariosPorDepartamento(id);
            for(int cont = 0; cont < funcionarios.size(); cont++){
                total += (funcionarios.get(cont).getSalario());
            }
            if(total <=  departamento.get().getOrcamento().getValor().doubleValue()){
                return "VERDE";
            }else if((total-departamento.get().getOrcamento().getValor().doubleValue()) <=  (departamento.get().getOrcamento().getValor().doubleValue() * 0.1)){
                return "AMARELO";
            }else{
                return "VERMELHO";
            }
        }
        return "Error";
    }
}
