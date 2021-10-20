package br.com.hotmart.apiteste.controller;

import br.com.hotmart.apiteste.dto.DepartamentoDTO;
import br.com.hotmart.apiteste.dto.DetalhesDepartamentoDTO;
import br.com.hotmart.apiteste.dto.DetalhesProjetoDTO;
import br.com.hotmart.apiteste.dto.ProjetoDTO;
import br.com.hotmart.apiteste.form.DepartamentoForm;
import br.com.hotmart.apiteste.form.DepartamentoUpdateForm;
import br.com.hotmart.apiteste.form.ProjetoForm;
import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.model.Projeto;
import br.com.hotmart.apiteste.repository.DepartamentoRepository;
import br.com.hotmart.apiteste.repository.ProjetoRepository;
import com.sun.xml.bind.v2.util.QNameMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    private List<Projeto> projetos;

    @GetMapping
    public List<ProjetoDTO> findAll(){
        projetos = (List<Projeto>) projetoRepository.findAll();
        return ProjetoDTO.converter(projetos);
    }

    @PostMapping
    public ResponseEntity<ProjetoDTO> create(@RequestBody @Valid ProjetoForm form, UriComponentsBuilder uriBuilder) {
        // Cria novo projeto para adicionar os atributos
        Projeto projeto = new Projeto();
        projeto.setNome(form.getNome());
        //Verificação para ver se o id de departamento passado no form é válido, ou seja, se há um departamento com o id passado
        Optional<Departamento> departamento = departamentoRepository.findById(form.getDepartamento().getId());
        //Passa para a variavel que será salva
        Departamento departamento_save = departamento.get();
        //Verifica se há algum objeto
        if(departamento.isPresent()){
            //Insere departamento na estrutura, departamento que veio do repositorio de departamentos
            projeto.setDepartamento(departamento_save);
            //Salva no banco de dados
            projetoRepository.save(projeto);
            //Redirecionamento de URL
            URI uri = uriBuilder.path("/projeto/{id}").buildAndExpand(projeto.getId()).toUri();
            return ResponseEntity.created(uri).body(new ProjetoDTO(projeto));
        }

        return	ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesProjetoDTO> detail(@PathVariable("id") Long id){
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if(projeto.isPresent()){
            return ResponseEntity.ok(new DetalhesProjetoDTO(projeto.get()));
        }
        return	ResponseEntity.notFound().build();

    }

    /*
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DepartamentoDTO> update(@PathVariable Long id,@RequestBody @Valid DepartamentoUpdateForm form) {
        Departamento departamento = form.update(id,departamentoRepository);
        if(departamento != null){
            return ResponseEntity.ok(new DepartamentoDTO(departamento));
        }
        return	ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DepartamentoDTO> safe_delete(@PathVariable Long id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        Departamento departamento_save = departamento.get();
        if(departamento != null){
            departamentoRepository.deleteById(id);
            return ResponseEntity.ok(new DepartamentoDTO(departamento_save));
        }
        return	ResponseEntity.notFound().build();
    }*/
}
