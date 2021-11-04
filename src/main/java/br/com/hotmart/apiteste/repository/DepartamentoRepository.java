package br.com.hotmart.apiteste.repository;

import br.com.hotmart.apiteste.model.Departamento;
import br.com.hotmart.apiteste.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>  {
    List<Departamento> findAll();
    Departamento findByNome(String nome);

    @Query("SELECT new br.com.hotmart.apiteste.model.Funcionario(f.id, f.salario, f.nome, f.cpf, f.dataNascimneto, f.sexo, f.endereco, f.supervisor_id) FROM Funcionario f JOIN FuncionarioProjeto fp ON f.id = fp.funcionario.id JOIN Projeto p ON fp.projeto.id = p.id JOIN Departamento d ON p.departamento.id = d.id WHERE d.id = :id")
    List<Funcionario> findSalariosPorDepartamento(Long id);
}
