# Sistema de Gestão Acadêmica (SGA)

Projeto desenvolvido como Atividade Prática Supervisionada (APS) da disciplina de Programação Orientada a Objetos (POO), com foco na criação de uma API REST utilizando Java e Spring Boot.

O sistema tem como objetivo gerenciar cursos e alunos de uma instituição de ensino, funcionando como backend para futuras aplicações web ou mobile.

## Autora
Amanda Félix Veras  
Curso Técnico em Desenvolvimento de Sistemas  
EEEP Alfredo Nunes de Melo  

## Objetivo
Desenvolver o backend de um Sistema de Gestão Acadêmica capaz de:
- Gerenciar o cadastro de cursos
- Gerenciar o cadastro de alunos
- Relacionar alunos a cursos
- Aplicar conceitos de POO, API REST, Spring Boot e JPA

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Banco de Dados H2 (em memória)
- Maven
- Postman ou Insomnia para testes da API

## Estrutura do Projeto

src/main  
├── java  
│   └── com  
│       └── sga  
│           └── academic  
│               ├── AcademicApplication.java  
│               ├── controller  
│               │   ├── AlunoController.java  
│               │   └── CursoController.java  
│               ├── model  
│               │   ├── Aluno.java  
│               │   └── Curso.java  
│               └── repository  
│                   ├── AlunoRepository.java  
│                   └── CursoRepository.java  
└── resources  
    └── application.properties  

## Como Executar o Projeto

1. Clone o repositório
2. Abra o projeto em uma IDE (IntelliJ IDEA ou Eclipse)
3. Execute a classe AcademicApplication.java
4. A aplicação será iniciada em http://localhost:8080

## Endpoints da API

### Cursos (/api/cursos)
- POST /api/cursos – Cadastrar um novo curso
- GET /api/cursos – Listar todos os cursos
- GET /api/cursos/{id} – Buscar um curso por ID
- DELETE /api/cursos/{id} – Remover um curso (somente se não houver alunos)

Exemplo de JSON:
{
  "nome": "Técnico em Informática",
  "sigla": "INF",
  "descricao": "Curso focado em desenvolvimento e suporte em TI."
}

### Alunos (/api/alunos)
- POST /api/alunos – Matricular um novo aluno
- GET /api/alunos – Listar todos os alunos
- GET /api/alunos/{id} – Buscar aluno por ID
- PUT /api/alunos/{id} – Atualizar dados do aluno
- DELETE /api/alunos/{id} – Remover aluno

Exemplo de JSON:
{
  "nome": "João da Silva",
  "matricula": "2024INF01",
  "email": "joao.silva@aluno.ce.gov.br",
  "curso": {
    "id": 1
  }
}

## Considerações Finais

Este projeto foi desenvolvido para fins acadêmicos, seguindo os requisitos da APS, com foco na organização do código, uso correto dos verbos HTTP e aplicação dos conceitos de Programação Orientada a Objetos.

## Disciplina
Programação Orientada a Objetos (POO)  
Professor Orientador: Daniel dos Santos Saraiva
