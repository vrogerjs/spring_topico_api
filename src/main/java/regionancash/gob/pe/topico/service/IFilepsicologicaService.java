package regionancash.gob.pe.topico.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.topico.model.File;
import regionancash.gob.pe.topico.model.Filepsicologica;

public interface IFilepsicologicaService extends ICRUD<Filepsicologica, Integer> {
    Page<Filepsicologica> findAllPagination(Pageable page);

    Page<Filepsicologica> findAllPaginationByIdPsicologica(Pageable page, Integer IdPsicologica);
}
