package br.com.hotmart.apiteste.repository;

import br.com.hotmart.apiteste.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>  {
    List<Departamento> findAll();
    Departamento findByNome(String nome);
}
