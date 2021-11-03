package br.com.hotmart.apiteste.controller;

import br.com.hotmart.apiteste.dto.OrcamentoDTO;
import br.com.hotmart.apiteste.form.OrcamentoForm;
import br.com.hotmart.apiteste.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {
    @Autowired
    private OrcamentoService orcamentoService;

    @GetMapping
    public List<OrcamentoDTO> getAllOrcamentos(){
        return OrcamentoDTO.converter(orcamentoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoDTO> getOne(@PathVariable("id") Long id){
        return ResponseEntity.ok(new OrcamentoDTO(orcamentoService.getOne(id)));
    }

    @PostMapping
    public ResponseEntity<OrcamentoDTO> create(@RequestBody @Valid OrcamentoForm form){
        return ResponseEntity.ok(new OrcamentoDTO(orcamentoService.createOrcamento(form)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrcamentoDTO> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(new OrcamentoDTO(orcamentoService.safe_delete(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrcamentoDTO> update(@PathVariable("id") Long id, @RequestBody @Valid OrcamentoForm form){
        return ResponseEntity.ok(new OrcamentoDTO(orcamentoService.update(id, form)));
    }
}
