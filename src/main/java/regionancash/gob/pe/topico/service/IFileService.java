package regionancash.gob.pe.topico.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Examen;
import regionancash.gob.pe.topico.model.File;

public interface IFileService extends ICRUD<File, Integer>{
    Page<File> findAllPagination(Pageable page);

    Page<File> findAllPaginationByIdHistoriaclinica(Pageable page, Integer IdHistoriaclinica);

}
