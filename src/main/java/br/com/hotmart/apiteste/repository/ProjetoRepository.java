package br.com.hotmart.apiteste.repository;

import br.com.hotmart.apiteste.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
