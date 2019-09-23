package br.com.poc.usecases;

import br.com.poc.exceptions.AlunoAlreadyExistsException;
import br.com.poc.repository.DisciplinaRepository;
import entity.Aluno;
import entity.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class MatricularAluno {

    @Autowired
    private DisciplinaRepository repository;

    public Disciplina matricularAluno(Disciplina disciplina, Aluno aluno) {

        if (disciplina.getAlunosMatriculados().contains(aluno)) {
            throw new AlunoAlreadyExistsException(aluno.getNome());
        }

        disciplina.adicionarAlunoDisciplina(aluno);

        return repository.save(disciplina);
    }
}
