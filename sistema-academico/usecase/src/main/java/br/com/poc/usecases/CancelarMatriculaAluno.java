package br.com.poc.usecases;

import br.com.poc.exceptions.AlunoDoesNotExistsException;
import br.com.poc.repository.DisciplinaRepository;
import entity.Aluno;
import entity.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class CancelarMatriculaAluno {

    @Autowired
    private DisciplinaRepository repository;

    public Disciplina cancelarMatricularAluno(Disciplina disciplina, Aluno aluno) {

        if (!disciplina.getAlunosMatriculados().contains(aluno)) {
            throw new AlunoDoesNotExistsException(aluno.getNome());
        }

        disciplina = disciplina.removerAlunoDisciplina(disciplina, aluno);

        return repository.save(disciplina);
    }
}
