package br.com.hotmart.apiteste.repository;

import br.com.hotmart.apiteste.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
    List<Orcamento> findAll();
}
