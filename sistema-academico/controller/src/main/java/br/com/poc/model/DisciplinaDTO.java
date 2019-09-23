package br.com.poc.model;

import entity.Disciplina;
import entity.Turma;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDTO {

    private String nome;
    private Turma turma;
    private int quantidadeVagas;
    private int quantidadeAlunosMatriculados;
    private AlunoDTO aluno;
    private List<AlunoDTO> alunosMatriculados;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
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

    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }

    public List<AlunoDTO> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(List<AlunoDTO> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }

    public Disciplina toDisciplina() {
        return Disciplina.builder()
                .nome(nome)
                .quantidadeAlunosMatriculados(quantidadeAlunosMatriculados)
                .quantidadeVagas(quantidadeVagas)
                .build();
    }

    public static DisciplinaDTO toDisciplinaDTO(final Disciplina disciplina) {
        DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
        disciplinaDTO.setNome(disciplina.getNome());
        disciplinaDTO.setQuantidadeAlunosMatriculados(disciplina.getQuantidadeAlunosMatriculados());
        disciplinaDTO.setQuantidadeVagas(disciplina.getQuantidadeAlunosMatriculados());
        List<AlunoDTO> alunoDTOS = new ArrayList<>();
        disciplina.getAlunosMatriculados().stream().forEach(a -> alunoDTOS.add(AlunoDTO.toAlunoDTO(a)));
        disciplinaDTO.setAlunosMatriculados(alunoDTOS);
        return disciplinaDTO;
    }
}
