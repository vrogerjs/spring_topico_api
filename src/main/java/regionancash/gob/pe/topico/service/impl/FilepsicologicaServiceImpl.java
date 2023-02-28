package regionancash.gob.pe.topico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.topico.model.Filepsicologica;
import regionancash.gob.pe.topico.repository.IFileRepository;
import regionancash.gob.pe.topico.repository.IFilepsicologicaRepository;
import regionancash.gob.pe.topico.service.IFilepsicologicaService;

@Service
public class FilepsicologicaServiceImpl extends CRUDImpl<Filepsicologica, Integer> implements IFilepsicologicaService {
    @Autowired
    private IFilepsicologicaRepository repo;

    @Override
    protected JpaRepository<Filepsicologica, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Filepsicologica> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public Page<Filepsicologica> findAllPaginationByIdPsicologica(Pageable page, Integer IdPsicologica) {
        return repo.searchByIdPsicologica(page, IdPsicologica);
    }
}
