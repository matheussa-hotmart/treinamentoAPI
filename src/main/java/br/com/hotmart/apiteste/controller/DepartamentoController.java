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
        return DepartamentoDTO.converter(departamentoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<DepartamentoDTO> create(@RequestBody @Valid DepartamentoForm form) {
        return ResponseEntity.ok(new DepartamentoDTO(departamentoService.createDepartamento(form)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDepartamentoDTO> detail(@PathVariable("id") Long id){
        return ResponseEntity.ok(new DetalhesDepartamentoDTO(departamentoService.getOneDepartamento(id)));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DepartamentoDTO> update(@PathVariable Long id,@RequestBody @Valid DepartamentoUpdateForm form) {
        return ResponseEntity.ok(new DepartamentoDTO(departamentoService.updateDepartamento(id,form)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DepartamentoDTO> safe_delete(@PathVariable Long id) {
        return ResponseEntity.ok(new DepartamentoDTO(departamentoService.safeDeleteDepartamento(id)));
    }
}
