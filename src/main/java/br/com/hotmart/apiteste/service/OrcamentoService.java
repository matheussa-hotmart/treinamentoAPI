package br.com.hotmart.apiteste.service;

import br.com.hotmart.apiteste.exceptions.EntityNotFoundException;
import br.com.hotmart.apiteste.form.OrcamentoForm;
import br.com.hotmart.apiteste.model.Orcamento;
import br.com.hotmart.apiteste.repository.OrcamentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrcamentoService {
    private final OrcamentoRepository orcamentoRepository;
    private String attribute = "id";
    private String why = "Orcamento not found with " +attribute+ ": ";

    @SuppressWarnings("Unchecked")
    public Orcamento createOrcamento(OrcamentoForm form){
        //retorna novo funcionario;
        Orcamento orcamento = new Orcamento(form);
        orcamentoRepository.save(orcamento);
        return orcamento;
    }

    @SuppressWarnings("Unchecked")
    public List<Orcamento> getAll(){
        return orcamentoRepository.findAll();
    }

    @SuppressWarnings("Unchecked")
    public Orcamento getOne(Long id){
        return orcamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(why+id));
    }

    @SuppressWarnings("Unchecked")
    public Orcamento safe_delete(Long id){
        Optional<Orcamento> orcamento = orcamentoRepository.findById(id);
        if(orcamento.isPresent()){
            orcamentoRepository.deleteById(id);
            return  orcamento.get();
        }
        this.attribute = "id";
        return orcamentoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(why+id));
    }

    @SuppressWarnings("Unchecked")
    public Orcamento update(Long id, OrcamentoForm form){
        Optional<Orcamento> orcamento = orcamentoRepository.findById(id);
        if(orcamento.isPresent()){
            orcamento.get().setValor(form.getValor());
            orcamento.get().setDataInicio(form.getDataInicio());
            orcamento.get().setDataFim(form.getDataFim());
            orcamentoRepository.save(orcamento.get());
            return orcamento.get();
        }
        this.attribute = "id";
        return orcamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(why+id));
    }
}
