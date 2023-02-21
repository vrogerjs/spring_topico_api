package regionancash.gob.pe.topico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Psicologica;
import regionancash.gob.pe.topico.service.IPsicologicaService;

import java.util.List;
@RestController
@RequestMapping("/psicologica")
public class PsicologicaController {
    @Autowired
    private IPsicologicaService service;

    @GetMapping
    public List<Psicologica> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<Psicologica>> findAllPagination(Pageable page) {
        Page<Psicologica> p = service.findAllPagination(page);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Psicologica readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @GetMapping("/{from}/{to}/{id}")
    public ResponseEntity<Page<Psicologica>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to, @PathVariable("id") Integer IdHistoriaclinica) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "fechaEvaluacion"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Psicologica> p = service.findAllPaginationByIdHistoriaclinica(pageable, IdHistoriaclinica);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PostMapping
    public Psicologica create(@RequestBody Psicologica psicologica) throws Exception {
        return service.create(psicologica);
    }

    @PutMapping
    public Psicologica update(@RequestBody Psicologica psicologica) throws Exception {
        return service.update(psicologica);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
