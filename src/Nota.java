public class Nota {
    private static final double NOTA_MINIMA = 0.0;
    private static final double NOTA_MAXIMA = 10.0;

    private final Aluno aluno;
    private double valor;
    private final String descricao;

    public Nota(Aluno aluno, double valor, String descricao) {
        if (aluno == null) {
            throw new IllegalArgumentException("A nota deve estar associada a um aluno.");
        }

        this.aluno = aluno;
        this.descricao = Pessoa.validarTexto(descricao, "descrição da atividade");
        setValor(valor);
    }

    public Aluno getAluno() {
        return aluno;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setValor(double valor) {
        if (!Double.isFinite(valor) || valor < NOTA_MINIMA || valor > NOTA_MAXIMA) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        this.valor = valor;
    }

    public void exibirNota() {
        System.out.printf("Aluno: %s | Atividade: %s | Nota: %.1f%n",
                aluno.getNome(), descricao, valor);
    }
}

