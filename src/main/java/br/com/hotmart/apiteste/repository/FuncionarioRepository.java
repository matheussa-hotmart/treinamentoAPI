package br.com.hotmart.apiteste.repository;

import br.com.hotmart.apiteste.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findAll();
}
