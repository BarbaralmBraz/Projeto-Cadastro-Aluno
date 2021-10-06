package com.projeto.alunos.service;

import java.util.List;
import java.util.Optional;

import com.projeto.alunos.dao.AlunoDao;
import com.projeto.alunos.model.Aluno;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AlunoService {

    @Autowired
    AlunoDao alunoDao;

    public Aluno findById(Long id) {
        return alunoDao.findById(id).orElse(null);
    }

    public List<Aluno> findBynome(String nomeAluno) {
        return alunoDao.findBynome(nomeAluno);
    }

    public List<Aluno> findBycurso(String nomeCurso) {
        return alunoDao.findBycurso(nomeCurso);
    }

    public List<Aluno> findAll() {
        return alunoDao.findAll();
    }

    public Aluno save(Aluno aluno) {
        return alunoDao.save(aluno);
    }

    public void deleteById(Long id) {
        alunoDao.deleteById(id);
    }

    public Aluno updateAlunoById(Long id, Aluno aluno) {

        Aluno alunoLocal = findById(id);

            if (alunoLocal != null && aluno != null) {
                if (aluno.getNome() != null) {
                    alunoLocal.setNome(aluno.getNome());
                }
                if (aluno.getCpf() != null) {
                    alunoLocal.setCpf(aluno.getCpf());
                }
                if (aluno.getRg() != null) {
                    alunoLocal.setRg(aluno.getRg());
                }
                if (aluno.getEndereco() != null) {
                    alunoLocal.setEndereco(aluno.getEndereco());
                }
                if (aluno.getCurso() != null) {
                    alunoLocal.setCurso(aluno.getCurso());
                }

                alunoDao.save(alunoLocal);
            }
        return alunoLocal;
    }

    
}
