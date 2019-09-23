package entity;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    private String nome;
    private int quantidadeVagas;
    private int quantidadeAlunosMatriculados;
    private List<Aluno> alunosMatriculados = new ArrayList<>();

    public Disciplina(String nome, int quantidadeVagas, int quantidadeAlunosMatriculados) {
        this.nome = nome;
        this.quantidadeVagas = quantidadeVagas;
        this.quantidadeAlunosMatriculados = quantidadeAlunosMatriculados;
    }

    public void adicionarAlunoDisciplina(Aluno aluno){
        if (this.quantidadeVagas > this.quantidadeAlunosMatriculados) {
            this.alunosMatriculados.add(aluno);
            this.quantidadeVagas = this.quantidadeVagas--;
            this.quantidadeAlunosMatriculados = this.quantidadeAlunosMatriculados++;
        }
    }

    public static DisciplinaBuilder builder() {
        return new DisciplinaBuilder();
    }

    public static class DisciplinaBuilder {
        private String nome;
        private int quantidadeVagas;
        private int quantidadeAlunosMatriculados;

        DisciplinaBuilder() {
        }

        public DisciplinaBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public DisciplinaBuilder quantidadeVagas(final int quantidadeVagas) {
            this.quantidadeVagas = quantidadeVagas;
            return this;
        }

        public DisciplinaBuilder quantidadeAlunosMatriculados(final int quantidadeAlunosMatriculados) {
            this.quantidadeAlunosMatriculados = quantidadeAlunosMatriculados;
            return this;
        }

        public Disciplina build() {
            return new Disciplina(nome, quantidadeVagas, quantidadeAlunosMatriculados);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeVagas() {
        return quantidadeVagas;
    }

    public void setQuantidadeVagas(int quantidadeVagas) {
        this.quantidadeVagas = quantidadeVagas;
    }

    public int getQuantidadeAlunosMatriculados() {
        return quantidadeAlunosMatriculados;
    }

    public void setQuantidadeAlunosMatriculados(int quantidadeAlunosMatriculados) {
        this.quantidadeAlunosMatriculados = quantidadeAlunosMatriculados;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(List<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }
}
