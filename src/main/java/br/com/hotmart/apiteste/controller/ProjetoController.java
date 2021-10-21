package br.com.hotmart.apiteste.controller;

import br.com.hotmart.apiteste.dto.DepartamentoDTO;
import br.com.hotmart.apiteste.dto.DetalhesDepartamentoDTO;
import br.com.hotmart.apiteste.dto.DetalhesProjetoDTO;
import br.com.hotmart.apiteste.dto.ProjetoDTO;
import br.com.hotmart.apiteste.form.DepartamentoForm;
import br.com.hotmart.apiteste.form.DepartamentoUpdateForm;
import br.com.hotmart.apiteste.form.ProjetoForm;
import br.com.hotmart.apiteste.form.ProjetoUpdateForm;
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
        // Cria vetor de projeto chamando todos
        projetos = (List<Projeto>) projetoRepository.findAll();
        //retorna um DTO
        return ProjetoDTO.converter(projetos);
    }

    @PostMapping
    public ResponseEntity<ProjetoDTO> create(@RequestBody @Valid ProjetoForm form, UriComponentsBuilder uriBuilder) {
        // Cria novo projeto para adicionar os atributos
        Projeto projeto = new Projeto();
        projeto = form.converter(departamentoRepository);
        //Verifica se há algum objeto
        if(projeto != null){
            //Salva no banco de dados
            projetoRepository.save(projeto);
            //Redirecionamento de URL
            URI uri = uriBuilder.path("/projeto/{id}").buildAndExpand(projeto.getId()).toUri();
            return ResponseEntity.created(uri).body(new ProjetoDTO(projeto));
        }
        //Retornou nulo então não foi encontrado departamento
        return	ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesProjetoDTO> detail(@PathVariable("id") Long id){
        //Tenta buscar algum projeto com o id passado por parametro
        Optional<Projeto> projeto = projetoRepository.findById(id);
        //Verificação para ver se capturou alguma informação no findById
        if(projeto.isPresent()){
            //Retorna o DTO do projeto
            return ResponseEntity.ok(new DetalhesProjetoDTO(projeto.get()));
        }
        //ID nao encontrado, não há registros no bd com o id passado por parametro
        return	ResponseEntity.notFound().build();

    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProjetoDTO> update(@PathVariable Long id,@RequestBody @Valid ProjetoUpdateForm form) {
        Projeto projeto = form.update(id,projetoRepository, departamentoRepository);
        if(projeto != null){
            return ResponseEntity.ok(new ProjetoDTO(projeto));
        }
        return	ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ProjetoDTO> safe_delete(@PathVariable Long id) {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        Projeto projeto_save = projeto.get();
        if(projeto != null){
            projetoRepository.deleteById(id);
            return ResponseEntity.ok(new ProjetoDTO(projeto_save));
        }
        return	ResponseEntity.notFound().build();
    }
}
