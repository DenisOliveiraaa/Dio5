package me.dio.Dio5.control;

import me.dio.Dio5.model.Tarefa;
import me.dio.Dio5.model.TarefaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    TarefaRepository repository;

    @GetMapping({"", "/"})
    public List<Tarefa> getTarefas() {
        return repository.findAll(Sort.by("descricao"));
    }

    @PostMapping({"", "/"})
    public Tarefa insere(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    @PutMapping({"", "/"})
    public Tarefa atualiza(@RequestBody Tarefa tarefa) {
        if (tarefa.getId() != null) {
            return repository.save(tarefa);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String exclui(@PathVariable("id") Long id) {
        if (id != null) {
            repository.deleteById(id);
            return "Excluído";
        }
        return null;
    }
}
