package regionancash.gob.pe.topico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.topico.model.Oficina;
import regionancash.gob.pe.topico.model.Paciente;
import regionancash.gob.pe.topico.service.IOficinaService;

import java.util.List;

@RestController
@RequestMapping("/oficina")
public class OficinaController{
    @Autowired
    private IOficinaService service;

    @GetMapping
    public List<Oficina> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Oficina>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Oficina> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Oficina readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Oficina create(@RequestBody Oficina oficina) throws Exception {
        return service.create(oficina);
    }

    @PutMapping
    public Oficina update(@RequestBody Oficina oficina) throws Exception {
        return service.update(oficina);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
