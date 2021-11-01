package br.com.hotmart.apiteste.controller;

import br.com.hotmart.apiteste.dto.FuncionarioDTO;
import br.com.hotmart.apiteste.form.FuncionarioForm;
import br.com.hotmart.apiteste.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping()
    public List<FuncionarioDTO> getAllFuncionario(){
        return FuncionarioDTO.converter(funcionarioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> getOneFuncionario(@PathVariable("id") Long id){
        return ResponseEntity.ok(new FuncionarioDTO(funcionarioService.getOneFuncionario(id)));
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> createFuncionario(@RequestBody @Valid FuncionarioForm form){
        return ResponseEntity.ok(new FuncionarioDTO(funcionarioService.createFuncionario(form)));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<FuncionarioDTO> updateFuncionario(@PathVariable("id") Long id, @RequestBody @Valid FuncionarioForm form){
        return ResponseEntity.ok(new FuncionarioDTO(funcionarioService.updateFuncionario(id, form)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> safeDelete(@PathVariable("id") Long id){
        return ResponseEntity.ok(new FuncionarioDTO(funcionarioService.safeDeleteFuncionario(id)));
    }

    @GetMapping("/departamento/{nomeDepartamento}")
    public List<FuncionarioDTO> funcionariosByDepartamentName(@PathVariable("nomeDepartamento") String nomeDepartamento){
        return FuncionarioDTO.converter(funcionarioService.getFuncionariosByDepartamentName(nomeDepartamento));
    }

    @GetMapping("/getByName/{nomeFuncionario}")
    public List<FuncionarioDTO> funcionarioByName(@PathVariable("nomeFuncionario") String nomeFuncionario){
        return FuncionarioDTO.converter(funcionarioService.findByName(nomeFuncionario)) ;
    }

    @GetMapping("/getSupervisor/{idSupervisor}")
    public List<FuncionarioDTO> funcionarioByName(@PathVariable("idSupervisor") Long supervisor){
        return FuncionarioDTO.converter(funcionarioService.findFuncionarioBySupervisor(supervisor)) ;
    }

}
