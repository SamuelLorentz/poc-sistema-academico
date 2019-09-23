package br.com.poc;

import br.com.poc.model.DisciplinaDTO;
import br.com.poc.usecases.CancelarMatriculaAluno;
import br.com.poc.usecases.MatricularAluno;
import entity.Aluno;
import entity.Disciplina;
import org.springframework.stereotype.Component;

@Component
public class DisciplinaController {

    private final MatricularAluno matricularAluno;
    private final CancelarMatriculaAluno cancelarMatriculaAluno;

    public DisciplinaController(MatricularAluno matricularAluno, CancelarMatriculaAluno cancelarMatriculaAluno) {
        this.matricularAluno = matricularAluno;
        this.cancelarMatriculaAluno = cancelarMatriculaAluno;
    }

    public Disciplina matricularAluno(final DisciplinaDTO disciplinaDTO) {
        Aluno aluno = disciplinaDTO.getAluno().toAluno();
        Disciplina disciplina = disciplinaDTO.toDisciplina();
        return matricularAluno.matricularAluno(disciplina, aluno);
    }

    public Disciplina cancelarMatricularAluno(final DisciplinaDTO disciplinaDTO) {
        Aluno aluno = disciplinaDTO.getAluno().toAluno();
        Disciplina disciplina = disciplinaDTO.toDisciplina();
        return cancelarMatriculaAluno.cancelarMatricularAluno(disciplina, aluno);
    }
}
