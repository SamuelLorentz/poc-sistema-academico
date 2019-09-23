package br.com.poc.controller;

import br.com.poc.DisciplinaController;
import br.com.poc.model.DisciplinaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final DisciplinaController controller;

    @Autowired
    public Controller(final DisciplinaController controller) {
        this.controller = controller;
    }

    @RequestMapping(value = "/matricula", method = RequestMethod.POST)
    public DisciplinaDTO createUser(@RequestBody final DisciplinaDTO disciplina) {
        return DisciplinaDTO.toDisciplinaDTO(controller.matricularAluno(disciplina));
    }

    @RequestMapping(value = "/matricula", method = RequestMethod.DELETE)
    public DisciplinaDTO login(@RequestBody final DisciplinaDTO disciplina) {
        return DisciplinaDTO.toDisciplinaDTO(controller.cancelarMatricularAluno(disciplina));
    }

}