package br.com.hotmart.apiteste.repository;

import br.com.hotmart.apiteste.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findAll();

    @Query("SELECT new br.com.hotmart.apiteste.model.Funcionario(f.id,f.nome,f.cpf,f.dataNascimneto,f.sexo, f.endereco,f.supervisor_id) FROM Funcionario f JOIN FuncionarioProjeto fp ON f.id = fp.funcionario.id JOIN Projeto p ON fp.projeto.id = p.id JOIN Departamento d ON p.departamento.id = d.id WHERE d.nome= :nome ")
    List<Funcionario> getFuncionarioByDepartamentName(@Param("nome") String nome);

    List<Funcionario> findFuncionarioByNome(String nome);
}
