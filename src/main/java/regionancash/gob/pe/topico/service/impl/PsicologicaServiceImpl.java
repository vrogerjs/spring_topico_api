package regionancash.gob.pe.topico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Historiaclinica;
import regionancash.gob.pe.topico.model.Psicologica;
import regionancash.gob.pe.topico.repository.IHistoriaclinicaRepository;
import regionancash.gob.pe.topico.repository.IPsicologicaRepository;
import regionancash.gob.pe.topico.service.IPsicologicaService;
@Service
public class PsicologicaServiceImpl extends CRUDImpl<Psicologica, Integer> implements IPsicologicaService {
    @Autowired
    private IPsicologicaRepository repo;

    @Override
    protected JpaRepository<Psicologica, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Psicologica> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public Page<Psicologica> findAllPaginationByIdHistoriaclinica(Pageable page, Integer IdHistoriaclinica) {
        return repo.searchByIdHistoriaclinica(page, IdHistoriaclinica);
    }
}
