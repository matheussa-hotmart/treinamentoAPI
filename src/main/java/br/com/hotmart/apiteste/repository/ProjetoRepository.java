package br.com.hotmart.apiteste.repository;

import br.com.hotmart.apiteste.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    List<Projeto> findAll();

    /*
    SELECT p.* from projeto as p JOIN funcionario_projeto as fp ON p.id=fp.projeto_id WHERE fp.funcionario_id = :idFuncionario

    @Query("SELECT new br.com.hotmart.apiteste.model.Projeto(p.id,p.nome,p.departamento) FROM Projeto p JOIN FuncionarioProjeto fp ON p.id = fp.funcionario.id WHERE fp.funcionario.id= :funcionarioId GROUP BY p.id")
    List<Projeto> findAllProjectsByFuncionarioId(Long id);*/
}
