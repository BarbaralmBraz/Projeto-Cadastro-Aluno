package com.projeto.alunos.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import lombok.Data;

@Table
@Entity
@Data
public class Aluno {
    
    @Id @GeneratedValue
	private Long id;
	private String nome;
	private String cpf;
    private String rg;
    private String endereco;
    private String curso;
}
