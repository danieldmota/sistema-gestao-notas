public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA ACADÊMICO DE GESTÃO DE NOTAS ===");

        Professor professor = new Professor(
                "Caique Lopes",
                "123.456.789-00",
                "caique.lopes@instituicao.edu.br");

        Disciplina disciplina = professor.cadastrarDisciplina(
                "Programação Orientada a Objetos", 80);

        Turma turma = professor.criarTurma(disciplina, professor);

        Aluno daniel = professor.cadastrarAluno(
                "Daniel Dourado Mota", "111.111.111-11", "daniel@email.com");
        Aluno italo = professor.cadastrarAluno(
                "Italo Luan", "222.222.222-22", "italo@email.com");
        Aluno mariana = professor.cadastrarAluno(
                "Mariana Alves", "333.333.333-33", "mariana@email.com");

        turma.adicionarAluno(daniel);
        turma.adicionarAluno(italo);
        turma.adicionarAluno(mariana);

        turma.adicionarAluno(daniel);

        turma.removerAluno(mariana);
        turma.adicionarAluno(mariana);

        turma.listarAlunos();

        Nota notaDanielProva = professor.lancarNota(daniel, 8.5, "Prova 1");
        Nota notaDanielTrabalho = professor.lancarNota(daniel, 8.8, "Trabalho");
        notaDanielTrabalho.setValor(9.0);

        Nota notaItaloProva = professor.lancarNota(italo, 7.5, "Prova 1");
        Nota notaItaloTrabalho = professor.lancarNota(italo, 8.0, "Trabalho");

        Nota notaMarianaProva = professor.lancarNota(mariana, 9.5, "Prova 1");
        Nota notaMarianaTrabalho = professor.lancarNota(mariana, 9.2, "Trabalho");

        turma.adicionarNota(notaDanielProva);
        turma.adicionarNota(notaDanielTrabalho);
        turma.adicionarNota(notaItaloProva);
        turma.adicionarNota(notaItaloTrabalho);
        turma.adicionarNota(notaMarianaProva);
        turma.adicionarNota(notaMarianaTrabalho);

        turma.listarNotas();

        daniel.consultarNotas();
        daniel.consultarTurmas();

        daniel.setEmail("daniel.dourado@email.com");

        System.out.println("\nDados dos objetos cadastrados:");
        professor.exibirDados();
        turma.getDisciplina().exibirDados();
        turma.getProfessor().exibirDados();
        daniel.exibirDados();
        notaDanielProva.exibirNota();

        System.out.println("\n=== FIM DA EXECUÇÃO ===");
    }
}
