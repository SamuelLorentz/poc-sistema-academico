package br.com.poc.model;

import entity.Aluno;

public class AlunoDTO {

    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Aluno toAluno() {
        return Aluno.builder()
                .id(id)
                .nome(nome)
                .build();
    }

    public static AlunoDTO toAlunoDTO(final Aluno Aluno) {
        AlunoDTO AlunoDTO = new AlunoDTO();
        AlunoDTO.setNome(Aluno.getNome());
        AlunoDTO.setId(Aluno.getId());
        return AlunoDTO;
    }
}
