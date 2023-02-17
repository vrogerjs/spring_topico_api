package regionancash.gob.pe.topico.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.topico.model.Oficina;


public interface IOficinaService extends ICRUD<Oficina, Integer> {
    Page<Oficina> findAllPagination(Pageable page);

}
