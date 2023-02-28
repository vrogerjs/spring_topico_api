package regionancash.gob.pe.topico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.topico.model.Filepsicologica;
import regionancash.gob.pe.topico.service.IFileService;
import regionancash.gob.pe.topico.service.IFilepsicologicaService;

import java.util.List;

@RestController
@RequestMapping("/filepsicologica")
public class FilepsicologicaController {
    @Autowired
    private IFilepsicologicaService service;

    @GetMapping
    public List<Filepsicologica> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<Filepsicologica>> findAllPagination(Pageable page) {
        Page<Filepsicologica> p = service.findAllPagination(page);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    @GetMapping("/{from}/{to}/{id}")
    public ResponseEntity<Page<Filepsicologica>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to, @PathVariable("id") Integer IdAtencion) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "fechaRegistro"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Filepsicologica> p = service.findAllPaginationByIdPsicologica(pageable, IdAtencion);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Filepsicologica readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Filepsicologica create(@RequestBody Filepsicologica file) throws Exception {
        return service.create(file);
    }

    @PutMapping
    public Filepsicologica update(@RequestBody Filepsicologica file) throws Exception {
        return service.update(file);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
