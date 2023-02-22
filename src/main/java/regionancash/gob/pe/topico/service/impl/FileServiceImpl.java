package regionancash.gob.pe.topico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Examen;
import regionancash.gob.pe.topico.model.File;
import regionancash.gob.pe.topico.repository.IExamenRepository;
import regionancash.gob.pe.topico.repository.IFileRepository;
import regionancash.gob.pe.topico.service.IFileService;

@Service
public class FileServiceImpl extends CRUDImpl<File, Integer> implements IFileService {

    @Autowired
    private IFileRepository repo;

    @Override
    protected JpaRepository<File, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<File> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public Page<File> findAllPaginationByIdAtencion(Pageable page, Integer IdAtencion) {
        return repo.searchByIdAtencion(page, IdAtencion);
    }
}
