package com.projeto.alunos.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.alunos.model.Aluno;
import com.projeto.alunos.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    
    @Autowired
	AlunoService alunoService = new AlunoService();

	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> adicionaAluno(@RequestBody Aluno aluno) {

        try {
		    Aluno alunoSalvo = alunoService.save(aluno);

		    return ResponseEntity.ok().body(alunoSalvo);
        }
        catch (Exception e) {
            return ResponseEntity.ok().body("Erro ao criar aluno.");
        }
	}

	@GetMapping
	public ResponseEntity<List<Aluno>> listaAlunos(String nome, String curso) {
		if (nome == null && curso == null) {
            return ResponseEntity.ok().body(alunoService.findAll());
        }
        else if (nome != null) {
            return ResponseEntity.ok().body(alunoService.findBynome(nome));
        }
        else {
            return ResponseEntity.ok().body(alunoService.findBycurso(curso));
        }
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscaPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(alunoService.findById(id));
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaPorId(@PathVariable Long id) {
        try {
		    alunoService.deleteById(id);
            return ResponseEntity.ok().body("Aluno apagado.");
        }
        catch (Exception e) {
            return ResponseEntity.ok().body("Erro ao apagar aluno.");
        }
	}

    @PatchMapping("/{id}")
    public ResponseEntity<Aluno> alteraAluno (@PathVariable Long id, @RequestBody Aluno aluno) {
        return ResponseEntity.ok().body(alunoService.updateAlunoById(id, aluno));
    }
}
