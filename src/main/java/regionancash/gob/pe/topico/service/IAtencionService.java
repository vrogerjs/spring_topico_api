package regionancash.gob.pe.topico.service;

import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Historiaclinica;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IAtencionService extends ICRUD<Atencion, Integer> {
    Page<Atencion> findAllPagination(Pageable page);

    Page<Atencion> findAllPaginationByIdHistoriaclinica(Pageable page, Integer IdHistoriaclinica);

    List findAllByRangoFechas(LocalDate fechaIni, LocalDate fechaFin);

    List<Atencion> searchByNroDocumento(String nroDocumento);

}

