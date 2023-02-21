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
import regionancash.gob.pe.topico.model.File;
import regionancash.gob.pe.topico.service.IFileService;
import regionancash.gob.pe.topico.service.IOficinaService;

import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private IFileService service;

    @GetMapping
    public List<File> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<File>> findAllPagination(Pageable page) {
        Page<File> p = service.findAllPagination(page);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    @GetMapping("/{from}/{to}/{id}")
    public ResponseEntity<Page<File>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to, @PathVariable("id") Integer IdHistoriaclinica) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "fechaRegistro"));
        var pageable = PageRequest.of(from, to, sort);
        Page<File> p = service.findAllPaginationByIdHistoriaclinica(pageable, IdHistoriaclinica);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public File readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public File create(@RequestBody File file) throws Exception {
        return service.create(file);
    }

    @PutMapping
    public File update(@RequestBody File file) throws Exception {
        return service.update(file);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
