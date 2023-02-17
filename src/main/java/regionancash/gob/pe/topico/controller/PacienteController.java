package regionancash.gob.pe.topico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Paciente;
import regionancash.gob.pe.topico.service.IPacienteService;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private IPacienteService service;

    @GetMapping
    public List<Paciente> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{id}")
    public Paciente readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<Paciente>> findAllPagination(Pageable page) {
        Page<Paciente> p = service.findAllPagination(page);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<Page<Paciente>> searchByParams(@PathVariable("search") String search, Pageable page) {
        Page<Paciente> p = service.searchByParams(search, page);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PostMapping
    public Paciente create(@RequestBody Paciente paciente) throws Exception {
        return service.create(paciente);
    }

    @PutMapping
    public Paciente update(@RequestBody Paciente paciente) throws Exception {
        return service.update(paciente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
