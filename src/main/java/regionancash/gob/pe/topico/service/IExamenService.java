package regionancash.gob.pe.topico.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Examen;

public interface IExamenService extends ICRUD<Examen, Integer> {
    Page<Examen> findAllPagination(Pageable page);
}
