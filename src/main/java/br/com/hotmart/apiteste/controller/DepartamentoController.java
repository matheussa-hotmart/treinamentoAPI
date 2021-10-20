package br.com.hotmart.apiteste.controller;

import br.com.hotmart.apiteste.dto.DepartamentoDTO;
import br.com.hotmart.apiteste.dto.DetalhesDepartamentoDTO;
import br.com.hotmart.apiteste.form.DepartamentoForm;
import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    private List<Departamento> departamentos;

    @GetMapping
    public List<DepartamentoDTO> findAll(){
        departamentos = (List<Departamento>) departamentoRepository.findAll();
        return DepartamentoDTO.converter(departamentos);
    }

    @PostMapping
    public ResponseEntity<DepartamentoDTO> cadastrar(@RequestBody @Valid DepartamentoForm form, UriComponentsBuilder uriBuilder) {

        Departamento departamento = new Departamento();
        departamento.setNome(form.getNome());
        departamento.setNumero(form.getNumero());
        departamentoRepository.save(departamento);

        URI uri = uriBuilder.path("/departamento/{id}").buildAndExpand(departamento.getId()).toUri();
        return ResponseEntity.created(uri).body(new DepartamentoDTO(departamento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDepartamentoDTO> detalhar(@PathVariable("id") Long id){
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if(departamento.isPresent()){
            return ResponseEntity.ok(new DetalhesDepartamentoDTO(departamento.get()));
        }
        return	ResponseEntity.notFound().build();

    }
}
