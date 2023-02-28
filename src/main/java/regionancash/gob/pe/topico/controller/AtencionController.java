package regionancash.gob.pe.topico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Historiaclinica;
import regionancash.gob.pe.topico.service.IAtencionService;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

    @GetMapping("/{from}/{to}/{id}")
    public ResponseEntity<Page<Atencion>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to, @PathVariable("id") Integer IdHistoriaclinica) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "fechaEvaluacion"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Atencion> p = service.findAllPaginationByIdHistoriaclinica(pageable, IdHistoriaclinica);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{fechaIni}/{fechaFin}")
    public ResponseEntity<List> searchByRangoFechas(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaIni,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        List p = service.findAllByRangoFechas(fechaIni, fechaFin);
        System.out.println(p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/paciente/recurrente/{nroDocumento}")
    public ResponseEntity<List<Atencion>> searchByNroDocumento(@PathVariable(value = "nroDocumento") String nroDocumento) {
        List<Atencion> p = service.searchByNroDocumento(nroDocumento);
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
