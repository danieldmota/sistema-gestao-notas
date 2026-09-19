import java.util.ArrayList;
import java.util.List;

public class Turma {
    private final String codigo;
    private final Disciplina disciplina;
    private final Professor professor;
    private final List<Aluno> alunos;
    private final List<Nota> notas;

    public Turma(String codigo, Disciplina disciplina, Professor professor) {
        this.codigo = Pessoa.validarTexto(codigo, "código da turma");

        if (disciplina == null) {
            throw new IllegalArgumentException("A disciplina é obrigatória.");
        }
        if (professor == null) {
            throw new IllegalArgumentException("O professor é obrigatório.");
        }

        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("O aluno é obrigatório.");
        }

        if (contemAluno(aluno)) {
            System.out.println("Aluno " + aluno.getNome() + " já está cadastrado na turma.");
            return;
        }

        alunos.add(aluno);
        aluno.vincularTurma(this);
    }

    public void removerAluno(Aluno aluno) {
        if (aluno == null) {
            return;
        }

        boolean removido = alunos.removeIf(
                cadastrado -> cadastrado.getMatricula().equals(aluno.getMatricula()));

        if (removido) {
            notas.removeIf(nota -> nota.getAluno().getMatricula().equals(aluno.getMatricula()));
            aluno.desvincularTurma(this);
        }
    }

    public void listarAlunos() {
        System.out.printf("\nAlunos da turma %s - %s:%n", codigo, disciplina.getNome());

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (Aluno aluno : alunos) {
            aluno.exibirDados();
        }
    }

    public void listarNotas() {
        System.out.printf("\nNotas da turma %s - %s:%n", codigo, disciplina.getNome());

        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota cadastrada.");
            return;
        }

        for (Nota nota : notas) {
            nota.exibirNota();
        }
    }

    public void adicionarNota(Nota nota) {
        if (nota == null) {
            throw new IllegalArgumentException("A nota é obrigatória.");
        }

        if (!contemAluno(nota.getAluno())) {
            throw new IllegalArgumentException(
                    "Não é possível adicionar a nota: o aluno não pertence à turma.");
        }

        notas.add(nota);
    }

    public String getCodigo() {
        return codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    boolean exibirNotasDoAluno(Aluno aluno) {
        boolean encontrou = false;

        for (Nota nota : notas) {
            if (nota.getAluno().getMatricula().equals(aluno.getMatricula())) {
                if (!encontrou) {
                    System.out.printf("Turma %s - %s:%n", codigo, disciplina.getNome());
                }
                nota.exibirNota();
                encontrou = true;
            }
        }

        return encontrou;
    }

    private boolean contemAluno(Aluno aluno) {
        return alunos.stream().anyMatch(
                cadastrado -> cadastrado.getMatricula().equals(aluno.getMatricula()));
    }
}

