package br.com.hotmart.apiteste.service;


import br.com.hotmart.apiteste.exceptions.EntityNotFoundException;
import br.com.hotmart.apiteste.form.DepartamentoForm;
import br.com.hotmart.apiteste.form.DepartamentoUpdateForm;
import br.com.hotmart.apiteste.form.EnderecoForm;
import br.com.hotmart.apiteste.form.EnderecoUpdateForm;
import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.model.Endereco;
import br.com.hotmart.apiteste.repository.DepartamentoRepository;
import br.com.hotmart.apiteste.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private String why = "Endereço not found with id: ";

    public Endereco createEndereco(EnderecoForm form) {
        Endereco endereco = new Endereco(form);
        enderecoRepository.save(endereco);
        return endereco;
    }

    @SuppressWarnings("Unchecked")
    public Endereco getOneEndereco(Long id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(why + id));
    }

    @SuppressWarnings("Unchecked")
    public Endereco updateEndereco(Long id, EnderecoUpdateForm form) {
        //Pesquisa departamento por id
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent()) {
            Endereco endereco_save = endereco.get();
            //Substitui informações que vem do formulário
            endereco_save.setCep(form.getCep());
            endereco_save.setCidade(form.getCidade());
            endereco_save.setPais(form.getPais());
            endereco_save.setRua(form.getRua());
            endereco_save.setUf(form.getUf());
            //Retorno de departamento
            enderecoRepository.save(endereco_save);
            return endereco_save;
        }
        return enderecoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(why + id));

    }

    public Endereco safeDeleteEndereco(Long id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent()) {
            enderecoRepository.deleteById(id);
            return endereco.get();
        }
        return enderecoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(why + id));

    }
}