package regionancash.gob.pe.topico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.AtencionSummary;
import regionancash.gob.pe.topico.model.Historiaclinica;
import regionancash.gob.pe.topico.repository.IAtencionRepository;
import regionancash.gob.pe.topico.service.IAtencionService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtencionServiceImpl extends CRUDImpl<Atencion, Integer> implements IAtencionService {

    @Autowired
    private IAtencionRepository repo;

    @Override
    protected JpaRepository<Atencion, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Atencion> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public Page<Atencion> findAllPaginationByIdHistoriaclinica(Pageable page, Integer IdHistoriaclinica) {
        return repo.searchByIdHistoriaclinica(page, IdHistoriaclinica);
    }

    @Override
    public List findAllByRangoFechas(LocalDate fechaIni, LocalDate fechaFin) {
        return repo.searchByRangoFechas(fechaIni, fechaFin).stream().map(v -> {
            Object[] vv = v;
            AtencionSummary as = new AtencionSummary();
            as.setApeNomb((String) vv[0]);
            as.setCantidad(((Number) vv[1]).intValue());

            return as;
        }).collect(Collectors.toList());
    }

    public List<Atencion> searchByNroDocumento(String nroDocumento) {
        System.out.println(nroDocumento);
        return repo.searchByNroDocumento(nroDocumento);
    }
}
