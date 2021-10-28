package br.com.hotmart.apiteste.controller;

import br.com.hotmart.apiteste.dto.FuncionarioDTO;
import br.com.hotmart.apiteste.dto.FuncionarioProjetoDTO;
import br.com.hotmart.apiteste.form.FuncionarioProjetoForm;
import br.com.hotmart.apiteste.model.Funcionario;
import br.com.hotmart.apiteste.model.FuncionarioProjeto;
import br.com.hotmart.apiteste.service.FuncionarioProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/funcionario_projeto")
public class FuncionarioProjetoController {

    @Autowired
    private FuncionarioProjetoService funcionarioProjetoService;

    @GetMapping
    public List<FuncionarioProjetoDTO> getAll(){
        return FuncionarioProjetoDTO.converter(funcionarioProjetoService.getAll());
    }
    @GetMapping("/{id}")
    public FuncionarioProjetoDTO getOne(@PathVariable("id") Long id){
        return new FuncionarioProjetoDTO(funcionarioProjetoService.getOne(id));
    }

    @PostMapping
    public FuncionarioProjetoDTO create(@RequestBody @Valid FuncionarioProjetoForm form){
        return new FuncionarioProjetoDTO(funcionarioProjetoService.create(form));
    }

    @DeleteMapping("/{id}")
    public FuncionarioProjetoDTO safeDelete(@PathVariable("id") Long id){
        return new FuncionarioProjetoDTO(funcionarioProjetoService.safeDelete(id));
    }

    @PutMapping("/{id}")
    public FuncionarioProjetoDTO update(@PathVariable("id") Long id, @RequestBody @Valid FuncionarioProjetoForm form){
        return new FuncionarioProjetoDTO(funcionarioProjetoService.update(id, form));
    }

    @GetMapping("/funcionariosDoDepartamento/{nomeDepartamento}")
    public List<FuncionarioDTO> funcionariosByDepartamentName(@PathVariable("nomeDepartamento") String nomeDepartamento){
        return FuncionarioDTO.converter(funcionarioProjetoService.getFuncionariosByDepartamentName(nomeDepartamento));
    }

}
