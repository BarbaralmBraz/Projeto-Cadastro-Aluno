# Projeto-Cadastro-Aluno

Projeto desenvolvido utilizando banco de dados h2 e spring boot.

Métodos disponíveis:

Criar aluno - POST

localhost:8080/aluno

body:
{
    "nome": "Ana",
    "cpf": "12355547565",
    "rg": "2543456",
    "endereco": "João Pessoa",
    "curso": "Computação"
}

Apagar aluno - DELETE

localhost:8080/aluno/id

Capturar alunos - GET

Por id:
localhost:8080/aluno/id

-- Pode usar apenas parte da String

Por nome:
localhost:8080/aluno?nome=Ana

Por curso:
localhost:8080/aluno?curso=Computação


Modificar aluno - PATCH

localhost:8080/aluno/id

body:
{
    "nome": "Ana",
    "cpf": "12355547",
    "rg": "254",
    "endereco": "Soledade",
    "curso": "Comput"
}
