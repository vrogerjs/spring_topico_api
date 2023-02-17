package regionancash.gob.pe.topico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.topico.model.Examen;
import regionancash.gob.pe.topico.service.IExamenService;
import regionancash.gob.pe.topico.service.IExamenService;

import java.util.List;
@RestController
@RequestMapping("/examen")
public class ExamenController {
    @Autowired
    private IExamenService service;

    @GetMapping
    public List<Examen> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<Examen>> findAllPagination(Pageable page) {
        Page<Examen> p = service.findAllPagination(page);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PostMapping
    public Examen create(@RequestBody Examen examen) throws Exception {
        return service.create(examen);
    }

    @PutMapping
    public Examen update(@RequestBody Examen examen) throws Exception {
        return service.update(examen);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
