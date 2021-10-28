package br.com.hotmart.apiteste.repository;

import br.com.hotmart.apiteste.model.Funcionario;
import br.com.hotmart.apiteste.model.FuncionarioProjeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioProjetoRepository extends JpaRepository<FuncionarioProjeto, Long> {
    List<FuncionarioProjeto> findAll();



}
