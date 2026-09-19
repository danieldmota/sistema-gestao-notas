public class Disciplina {
    private final String codigo;
    private final String nome;
    private final int cargaHoraria;

    public Disciplina(String codigo, String nome, int cargaHoraria) {
        this.codigo = Pessoa.validarTexto(codigo, "código da disciplina");
        this.nome = Pessoa.validarTexto(nome, "nome da disciplina");

        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("A carga horária deve ser maior que zero.");
        }
        this.cargaHoraria = cargaHoraria;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void exibirDados() {
        System.out.printf("Disciplina: %s | Código: %s | Carga horária: %d horas%n",
                nome, codigo, cargaHoraria);
    }
}

