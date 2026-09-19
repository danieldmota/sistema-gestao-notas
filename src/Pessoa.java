public abstract class Pessoa {
    private final String nome;
    private final String cpf;
    private String email;

    protected Pessoa(String nome, String cpf, String email) {
        this.nome = validarTexto(nome, "nome");
        this.cpf = validarTexto(cpf, "CPF");
        this.email = validarTexto(email, "e-mail");
    }

    public abstract void exibirDados();

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = validarTexto(email, "e-mail");
    }

    protected static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("O campo " + campo + " é obrigatório.");
        }
        return valor.trim();
    }
}

