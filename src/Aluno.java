import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private static int proximaMatricula = 1;

    private final String matricula;
    private final List<Turma> turmas;

    public Aluno(String nome, String cpf, String email) {
        super(nome, cpf, email);
        this.matricula = String.format("A%04d", proximaMatricula++);
        this.turmas = new ArrayList<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public void consultarNotas() {
        System.out.println("\nNotas de " + getNome() + ":");

        if (turmas.isEmpty()) {
            System.out.println("Nenhuma nota encontrada.");
            return;
        }

        boolean encontrouNota = false;
        for (Turma turma : turmas) {
            encontrouNota = turma.exibirNotasDoAluno(this) || encontrouNota;
        }

        if (!encontrouNota) {
            System.out.println("Nenhuma nota encontrada.");
        }
    }

    public void consultarTurmas() {
        System.out.println("\nTurmas de " + getNome() + ":");

        if (turmas.isEmpty()) {
            System.out.println("O aluno não está vinculado a nenhuma turma.");
            return;
        }

        for (Turma turma : turmas) {
            System.out.printf("- %s | %s | Professor: %s%n",
                    turma.getCodigo(),
                    turma.getDisciplina().getNome(),
                    turma.getProfessor().getNome());
        }
    }

    void vincularTurma(Turma turma) {
        if (!turmas.contains(turma)) {
            turmas.add(turma);
        }
    }

    void desvincularTurma(Turma turma) {
        turmas.remove(turma);
    }

    @Override
    public void exibirDados() {
        System.out.printf("Aluno: %s | Matrícula: %s | CPF: %s | E-mail: %s%n",
                getNome(), matricula, getCpf(), getEmail());
    }
}

