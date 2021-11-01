package br.com.hotmart.apiteste.controller;

import br.com.hotmart.apiteste.dto.DetalhesProjetoDTO;
import br.com.hotmart.apiteste.dto.ProjetoDTO;
import br.com.hotmart.apiteste.form.ProjetoForm;
import br.com.hotmart.apiteste.form.ProjetoUpdateForm;
import br.com.hotmart.apiteste.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<ProjetoDTO> findAll(){
        return ProjetoDTO.converter(projetoService.getAll());
    }

    @PostMapping
    public ResponseEntity<ProjetoDTO> create(@RequestBody @Valid ProjetoForm form) {
        return ResponseEntity.ok(new ProjetoDTO(projetoService.createProjeto(form)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesProjetoDTO> detail(@PathVariable("id") Long id){
        return ResponseEntity.ok(new DetalhesProjetoDTO(projetoService.getOneProjeto(id)));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProjetoDTO> update(@PathVariable Long id,@RequestBody @Valid ProjetoUpdateForm form) {
        return ResponseEntity.ok(new ProjetoDTO(projetoService.updateProjeto(id,form)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ProjetoDTO> safe_delete(@PathVariable Long id) {
        return ResponseEntity.ok(new ProjetoDTO(projetoService.safeDeleteProjeto(id)));
    }

    /*@GetMapping("/getProjetosByFuncionarioId")
    public List<ProjetoDTO> getProjetosByFuncionarioId(@PathVariable Long id){
        return ProjetoDTO.converter(projetoService.getAllByFuncionario(id));
    }*/
}
