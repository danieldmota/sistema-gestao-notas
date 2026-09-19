public class Professor extends Pessoa {
    private static int proximoRegistro = 1;
    private static int proximoCodigoDisciplina = 1;
    private static int proximoCodigoTurma = 1;

    private final String registro;

    public Professor(String nome, String cpf, String email) {
        super(nome, cpf, email);
        this.registro = String.format("P%04d", proximoRegistro++);
    }

    public String getRegistro() {
        return registro;
    }

    public Aluno cadastrarAluno(String nome, String cpf, String email) {
        return new Aluno(nome, cpf, email);
    }

    public Disciplina cadastrarDisciplina(String nome, int cargaHoraria) {
        String codigo = String.format("DISC%03d", proximoCodigoDisciplina++);
        return new Disciplina(codigo, nome, cargaHoraria);
    }

    public Turma criarTurma(Disciplina disciplina, Professor professor) {
        if (disciplina == null) {
            throw new IllegalArgumentException("A disciplina é obrigatória.");
        }
        if (professor == null) {
            throw new IllegalArgumentException("O professor é obrigatório.");
        }

        String codigo = String.format("TURMA%03d", proximoCodigoTurma++);
        return new Turma(codigo, disciplina, professor);
    }

    public Nota lancarNota(Aluno aluno, double valor, String descricao) {
        return new Nota(aluno, valor, descricao);
    }

    @Override
    public void exibirDados() {
        System.out.printf("Professor: %s | Registro: %s | CPF: %s | E-mail: %s%n",
                getNome(), registro, getCpf(), getEmail());
    }
}

