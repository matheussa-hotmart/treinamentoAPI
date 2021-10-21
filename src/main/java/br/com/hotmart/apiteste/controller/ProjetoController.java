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
import br.com.hotmart.apiteste.service.ProjetoService;
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

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<ProjetoDTO> findAll(){
        // Cria vetor de projeto chamando todos
        List<Projeto> projetos = (List<Projeto>) projetoRepository.findAll();
        //retorna um DTO
        return ProjetoDTO.converter(projetos);
    }

    @PostMapping
    public ResponseEntity<ProjetoDTO> create(@RequestBody @Valid ProjetoForm form) {
        //Projeto é criado e chamado pela função do service como retorno
        Projeto projeto = projetoService.createProjeto(form);
        //Verifica se as operações deram certo
        if(projeto != null){
            //retorna um projetoDTO como sucesso
            return ResponseEntity.ok(new ProjetoDTO(projeto));
        }
        //Retornou nulo então não foi encontrado projeto
        return	ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesProjetoDTO> detail(@PathVariable("id") Long id){
        //Projeto é pesquisado pelo service e retorna um projeto
        Projeto projeto = projetoService.getOneProjeto(id);
        if(projeto != null){
            //Retorna o DTO do projeto
            return ResponseEntity.ok(new DetalhesProjetoDTO(projeto));
        }
        //ID nao encontrado, não há registros no bd com o id passado por parametro
        return	ResponseEntity.notFound().build();

    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProjetoDTO> update(@PathVariable Long id,@RequestBody @Valid ProjetoUpdateForm form) {
        // Recebe um projeto que foi operado pelo service
        Projeto projeto = projetoService.updateProjeto(id,form);
        //Verificação de objeto nulo
        if(projeto != null){
            //retorno com sucesso
            return ResponseEntity.ok(new ProjetoDTO(projeto));
        }
        //Projeto ou departamento não encontrado
        return	ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ProjetoDTO> safe_delete(@PathVariable Long id) {
        // Retorna o projeto que foi operado(exclusão) pelo service
        Projeto projeto = projetoService.safeDeleteProjeto(id);
        //Verificador de objeto
        if(projeto != null){
            //Deleta o projeto do id passado do BD
            departamentoRepository.deleteById(id);
            //Exclusão feita com sucesso
            return ResponseEntity.ok(new ProjetoDTO(projeto));
        }
        //Projeto com id passado não encontrado
        return	ResponseEntity.notFound().build();
    }
}
