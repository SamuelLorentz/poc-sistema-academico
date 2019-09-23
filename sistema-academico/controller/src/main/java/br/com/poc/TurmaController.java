package br.com.poc;

import br.com.poc.repository.TurmaRepository;
import entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;

public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    public Turma recuperarTurmaPorId(int id){
        return repository.findById(id).orElse(new Turma());
    }
}
