package br.com.poc.usecases;

import br.com.poc.exceptions.AlunoAlreadyExistsException;
import br.com.poc.exceptions.AlunoDoesNotExistsException;
import br.com.poc.repository.DisciplinaRepository;
import entity.Aluno;
import entity.Disciplina;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CancelarMatriculaAlunoTest {

    @Mock
    private DisciplinaRepository disciplinaRepository;

    @InjectMocks
    CancelarMatriculaAluno cancelarMatriculaAluno;

    @Test
    public void cancelarMatricularAlunoSucesso() {

        Disciplina disciplina = new Disciplina("Calculo I", 9,1);
        Aluno aluno = new Aluno(1, "Teste Aluno");
        disciplina.getAlunosMatriculados().add(aluno);

        when(disciplinaRepository.save(disciplina)).thenReturn(disciplina);

        Disciplina retorno = cancelarMatriculaAluno.cancelarMatricularAluno(disciplina, aluno);

        assertTrue(retorno.getQuantidadeVagas() == 10);
        assertTrue(retorno.getQuantidadeAlunosMatriculados() == 0);
        assertTrue(!retorno.getAlunosMatriculados().contains(aluno));
    }

    @Test(expected = AlunoDoesNotExistsException.class)
    public void alunoNaoMatriculadoNaDisciplina() {

        Disciplina disciplina = new Disciplina("Calculo I", 9,1);
        Aluno aluno = new Aluno(1, "Teste Aluno");
        disciplina.getAlunosMatriculados().add(aluno);

        Disciplina retorno = cancelarMatriculaAluno.cancelarMatricularAluno(disciplina, new Aluno(2, "Não Existe"));
    }
}