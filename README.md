# Sistema de Gestão de Notas

Projeto em Java criado para representar o funcionamento básico de uma turma. O programa cadastra professores, alunos e disciplinas, organiza os alunos em turmas e registra suas notas.

## Funcionalidades

- Cadastro de professor, alunos e disciplina.
- Criação de turma com professor e disciplina.
- Inclusão e remoção de alunos.
- Bloqueio de alunos duplicados na mesma turma.
- Registro e alteração de notas entre 0 e 10.
- Consulta de notas e turmas de cada aluno.
- Geração automática de matrículas, registros e códigos.

## Estrutura das classes

- `Pessoa`: reúne nome, CPF e e-mail.
- `Aluno`: herda de `Pessoa` e mantém matrícula e turmas.
- `Professor`: herda de `Pessoa` e realiza os cadastros e lançamentos.
- `Disciplina`: armazena código, nome e carga horária.
- `Turma`: relaciona professor, disciplina, alunos e notas.
- `Nota`: representa uma atividade, seu valor e o aluno avaliado.
- `Main`: cria os objetos e executa um exemplo completo do sistema.

## Como executar

Na pasta principal do projeto, compile e execute com:

```bash
javac -d out src/*.java
java -cp out Main
```

O projeto utiliza somente a biblioteca padrão do Java.

## Decisões de implementação

- As notas são aceitas apenas no intervalo de 0 a 10.
- Matrículas, registros e códigos são criados por contadores internos.
- Um aluno só pode receber nota se estiver cadastrado na turma.
- Quando um aluno é removido, suas notas naquela turma também são apagadas.
- As listas de alunos, turmas e notas usam `ArrayList`.

## Conceitos de POO utilizados

- **Herança:** `Aluno` e `Professor` aproveitam os atributos e métodos de `Pessoa`.
- **Encapsulamento:** os atributos são privados e o acesso acontece pelos métodos das classes.
- **Polimorfismo:** alunos e professores possuem suas próprias implementações de `exibirDados()`.
- **Associação:** a turma mantém relações com uma disciplina, um professor, seus alunos e suas notas.
- **Abstração:** cada classe representa uma parte específica do sistema acadêmico.
