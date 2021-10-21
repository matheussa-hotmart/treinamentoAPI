package br.com.hotmart.apiteste.controller;

import br.com.hotmart.apiteste.dto.DepartamentoDTO;
import br.com.hotmart.apiteste.dto.DetalhesDepartamentoDTO;
import br.com.hotmart.apiteste.form.DepartamentoForm;
import br.com.hotmart.apiteste.form.DepartamentoUpdateForm;
import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.repository.DepartamentoRepository;
import br.com.hotmart.apiteste.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<DepartamentoDTO> findAll(){
        List<Departamento> departamentos = (List<Departamento>) departamentoRepository.findAll();
        return DepartamentoDTO.converter(departamentos);
    }

    @PostMapping
    public ResponseEntity<DepartamentoDTO> create(@RequestBody @Valid DepartamentoForm form) {
        Departamento departamento = departamentoService.createDepartamento(form);
        if(departamento != null){
            return ResponseEntity.ok(new DepartamentoDTO(departamento));
        }
        return	ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDepartamentoDTO> detail(@PathVariable("id") Long id){
        Departamento departamento = departamentoService.getOneDepartamento(id);
        if(departamento != null){
            return ResponseEntity.ok(new DetalhesDepartamentoDTO(departamento));
        }
        return	ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DepartamentoDTO> update(@PathVariable Long id,@RequestBody @Valid DepartamentoUpdateForm form) {
        Departamento departamento = departamentoService.updateDepartamento(id,form);
        if(departamento != null){
            return ResponseEntity.ok(new DepartamentoDTO(departamento));
        }
        return	ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DepartamentoDTO> safe_delete(@PathVariable Long id) {
        Departamento departamento = departamentoService.safeDeleteDepartamento(id);
        if(departamento != null){
            departamentoRepository.deleteById(id);
            return ResponseEntity.ok(new DepartamentoDTO(departamento));
        }
        return	ResponseEntity.notFound().build();
    }
}
