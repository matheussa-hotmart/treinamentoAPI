package br.com.hotmart.apiteste.controller;

import br.com.hotmart.apiteste.dto.DepartamentoDTO;
import br.com.hotmart.apiteste.form.DepartamentoForm;
import br.com.hotmart.apiteste.service.DepartamentoService;
import org.apache.coyote.Response;
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
    private DepartamentoService departamentoService;

    @GetMapping
    public List<DepartamentoDTO> findAll(){
        return DepartamentoDTO.converter(departamentoService.getAll());
    }

    @PostMapping
    public ResponseEntity<DepartamentoDTO> create(@RequestBody @Valid DepartamentoForm form) {
        return ResponseEntity.ok(new DepartamentoDTO(departamentoService.createDepartamento(form)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> detail(@PathVariable("id") Long id){
        return ResponseEntity.ok(new DepartamentoDTO(departamentoService.getOneDepartamento(id)));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DepartamentoDTO> update(@PathVariable Long id,@RequestBody @Valid DepartamentoForm form) {
        return ResponseEntity.ok(new DepartamentoDTO(departamentoService.updateDepartamento(id,form)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DepartamentoDTO> safeDelete(@PathVariable Long id) {
        return ResponseEntity.ok(new DepartamentoDTO(departamentoService.safeDeleteDepartamento(id)));
    }

    @GetMapping("/statusOrcamento/{id}")
    public ResponseEntity<String> statusOrcamento(@PathVariable Long id){
        return ResponseEntity.ok(departamentoService.statusOrcamento(id));
    }
}
