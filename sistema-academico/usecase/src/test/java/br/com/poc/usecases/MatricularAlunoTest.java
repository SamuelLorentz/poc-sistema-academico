package br.com.poc.usecases;

import br.com.poc.exceptions.AlunoAlreadyExistsException;
import br.com.poc.repository.DisciplinaRepository;
import entity.Aluno;
import entity.Disciplina;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MatricularAlunoTest {

    @Mock
    private DisciplinaRepository disciplinaRepository;

    @InjectMocks
    MatricularAluno matricularAluno;

    @Test
    public void matricularAlunoSucesso() {

        Disciplina disciplina = new Disciplina("Calculo I", 10,0);
        when(disciplinaRepository.save(any())).thenReturn(disciplina);

        Aluno aluno = new Aluno(1, "Teste Aluno");

        Disciplina retorno = matricularAluno.matricularAluno(disciplina, aluno);

        assertTrue(retorno.getQuantidadeVagas() == 9);
        assertTrue(retorno.getQuantidadeAlunosMatriculados() == 1);
        assertTrue(retorno.getAlunosMatriculados().contains(aluno));
    }

    @Test(expected = AlunoAlreadyExistsException.class)
    public void matricularAlunoJaMatriculado() {

        Disciplina disciplina = new Disciplina("Calculo I", 9,1);

        Aluno aluno = new Aluno(1, "Teste Aluno");
        disciplina.adicionarAlunoDisciplina(disciplina, aluno);

        Disciplina retorno = matricularAluno.matricularAluno(disciplina, aluno);
    }
}