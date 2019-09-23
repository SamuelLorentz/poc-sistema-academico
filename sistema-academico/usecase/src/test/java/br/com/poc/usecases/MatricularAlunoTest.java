package br.com.poc.usecases;

import br.com.poc.repository.DisciplinaRepository;
import entity.Aluno;
import entity.Disciplina;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MatricularAlunoTest {
    @Test
    public void matricularAluno() {

        DisciplinaRepository repository = mock(DisciplinaRepository.class);

        MatricularAluno matricularAluno = new MatricularAluno();

        Disciplina disciplina = new Disciplina("Calculo I", 10,0);
        Aluno aluno = new Aluno(1, "Teste Aluno");

        when(repository.save(any())).thenReturn(disciplina);

        Disciplina retorno = matricularAluno.matricularAluno(disciplina, aluno);

        assertTrue(retorno.getQuantidadeVagas() == 9);
        assertTrue(retorno.getQuantidadeAlunosMatriculados() == 1);
        assertTrue(retorno.getAlunosMatriculados().contains(aluno));
    }
}