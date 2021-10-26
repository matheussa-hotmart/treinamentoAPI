package br.com.hotmart.apiteste.controller;

import br.com.hotmart.apiteste.dto.DetalhesEnderecoDTO;
import br.com.hotmart.apiteste.dto.EnderecoDTO;
import br.com.hotmart.apiteste.form.EnderecoForm;
import br.com.hotmart.apiteste.form.EnderecoUpdateForm;
import br.com.hotmart.apiteste.repository.EnderecoRepository;
import br.com.hotmart.apiteste.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departamento")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoDTO> findAll(){
        return EnderecoDTO.converter(enderecoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> create(@RequestBody @Valid EnderecoForm form) {
        return ResponseEntity.ok(new EnderecoDTO(enderecoService.createEndereco(form)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesEnderecoDTO> detail(@PathVariable("id") Long id){
        return ResponseEntity.ok(new DetalhesEnderecoDTO(enderecoService.getOneEndereco(id)));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EnderecoDTO> update(@PathVariable Long id,@RequestBody @Valid EnderecoUpdateForm form) {
        return ResponseEntity.ok(new EnderecoDTO(enderecoService.updateEndereco(id,form)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<EnderecoDTO> safe_delete(@PathVariable Long id) {
        return ResponseEntity.ok(new EnderecoDTO(enderecoService.safeDeleteEndereco(id)));
    }
}