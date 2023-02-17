package regionancash.gob.pe.topico.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Historiaclinica;

public interface IAtencionService extends ICRUD<Atencion, Integer>{
    Page<Atencion> findAllPagination(Pageable page);

    Page<Atencion> findAllPaginationByIdHistoriaclinica(Integer IdHistoriaclinica, Pageable page);

}

