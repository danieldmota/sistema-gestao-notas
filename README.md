# Sistema Acadêmico de Gestão de Notas

Projeto desenvolvido em Java para a atividade prática de Programação Orientada a Objetos.

## Funcionalidades implementadas

- Herança entre `Pessoa`, `Aluno` e `Professor`.
- Cadastro de professor, disciplina, turma e alunos.
- Geração automática de registro, matrícula e códigos.
- Inclusão e remoção de alunos da turma.
- Bloqueio de aluno duplicado na mesma turma.
- Lançamento de notas entre 0 e 10.
- Validação para impedir notas de alunos que não pertencem à turma.
- Consulta das turmas e notas de um aluno.
- Cenário completo de execução na classe `Main`.

## Estrutura

Cada classe está em seu próprio arquivo dentro da pasta `src`:

- `Pessoa.java`
- `Aluno.java`
- `Professor.java`
- `Disciplina.java`
- `Turma.java`
- `Nota.java`
- `Main.java`

## Como executar

No terminal, a partir da pasta raiz do projeto:

```bash
javac -d out src/*.java
java -cp out Main
```

O projeto utiliza apenas recursos básicos da biblioteca padrão do Java e não depende de banco de dados, interface gráfica ou bibliotecas externas.

## Decisões de implementação

- As notas válidas ficam no intervalo de 0 a 10.
- Os identificadores são gerados por contadores internos: `P0001`, `A0001`, `DISC001` e `TURMA001`.
- O aluno mantém internamente suas turmas para que `consultarTurmas()` e `consultarNotas()` funcionem sem parâmetros.
- Ao remover um aluno de uma turma, suas notas naquela turma também são removidas para manter a consistência dos dados.

## Conceitos de POO utilizados

- **Abstração:** `Pessoa` representa as informações comuns a alunos e professores.
- **Herança:** `Aluno` e `Professor` estendem `Pessoa`.
- **Encapsulamento:** os atributos são privados e acessados por métodos das classes.
- **Polimorfismo:** `Aluno` e `Professor` implementam `exibirDados()` de maneiras diferentes.
- **Associação:** uma `Turma` se relaciona com uma `Disciplina`, um `Professor`, vários alunos e várias notas.

## Como publicar em um repositório Git

Depois de criar um repositório vazio no GitHub, execute na pasta do projeto:

```bash
git init
git add .
git commit -m "Implementa sistema acadêmico de gestão de notas"
git branch -M main
git remote add origin URL_DO_REPOSITORIO
git push -u origin main
```
