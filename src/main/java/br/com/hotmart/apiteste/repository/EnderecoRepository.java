package br.com.hotmart.apiteste.repository;

import br.com.hotmart.apiteste.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findAll();
}
