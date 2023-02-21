package regionancash.gob.pe.topico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.topico.model.Historiaclinica;
import regionancash.gob.pe.topico.model.Oficina;
import regionancash.gob.pe.topico.model.Paciente;
import regionancash.gob.pe.topico.service.IHistoriaclinicaService;

import java.util.List;

@RestController
@RequestMapping("/historiaclinica")
public class HistoriaclinicaController {
    @Autowired
    private IHistoriaclinicaService service;

    @GetMapping
    public List<Historiaclinica> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{id}")
    public Historiaclinica readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @GetMapping("/one")
    public List<Historiaclinica> getOneHistoriaclinica() throws Exception {
        return service.getOneHistoriaclinica();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Historiaclinica>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "numero"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Historiaclinica> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/pagination/{id}")
    public ResponseEntity<Page<Historiaclinica>> findAllPaginationById(@PathVariable("id") Integer id, Pageable page) {
        Page<Historiaclinica> p = service.findAllPaginationById(id,page);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<Page<Historiaclinica>> searchByParams(@PathVariable("search") String search, Pageable page) {
        Page<Historiaclinica> p = service.searchByParams(search, page);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PostMapping
    public Historiaclinica create(@RequestBody Historiaclinica historiaclinica) throws Exception {
        return service.create(historiaclinica);
    }

    @PutMapping
    public Historiaclinica update(@RequestBody Historiaclinica historiaclinica) throws Exception {
        return service.update(historiaclinica);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
