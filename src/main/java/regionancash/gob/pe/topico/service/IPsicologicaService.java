package regionancash.gob.pe.topico.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Psicologica;

public interface IPsicologicaService extends ICRUD<Psicologica, Integer> {
    Page<Psicologica> findAllPagination(Pageable page);

    Page<Psicologica> findAllPaginationByIdHistoriaclinica(Pageable page, Integer IdHistoriaclinica);

}
