package com.projeto.alunos.dao;

import com.projeto.alunos.model.Aluno;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface AlunoDao extends JpaRepository<Aluno, Long> {

    @Query("Select c from Aluno c where c.nome like %:nomeAluno%")
    List<Aluno> findBynome(String nomeAluno);

    @Query("Select c from Aluno c where c.curso like %:nomeCurso%")
    List<Aluno> findBycurso(String nomeCurso);
}
