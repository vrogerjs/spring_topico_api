package regionancash.gob.pe.topico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.service.IAtencionService;

import java.util.List;

@RestController
@RequestMapping("/atencion")
public class AtencionController {

    @Autowired
    private IAtencionService service;

    @GetMapping
    public List<Atencion> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{id}")
    public Atencion readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<Atencion>> findAllPagination(Pageable page) {
        Page<Atencion> p = service.findAllPagination(page);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/pagination/{id}")
    public ResponseEntity<Page<Atencion>> findAllPaginationByIdHistoriaclinica(@PathVariable("id") Integer IdHistoriaclinica, Pageable page) {
//        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
//        var page = PageRequest.of(page, sort);
        Page<Atencion> p = service.findAllPaginationByIdHistoriaclinica(IdHistoriaclinica,page);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PostMapping
    public Atencion create(@RequestBody Atencion atencion) throws Exception {
        return service.create(atencion);
    }

    @PutMapping
    public Atencion update(@RequestBody Atencion atencion) throws Exception {
        return service.update(atencion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
