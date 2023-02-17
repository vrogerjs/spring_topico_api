package regionancash.gob.pe.topico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Examen;
import regionancash.gob.pe.topico.repository.IAtencionRepository;
import regionancash.gob.pe.topico.repository.IExamenRepository;
import regionancash.gob.pe.topico.service.IExamenService;

@Service
public class ExamenServiceImpl extends CRUDImpl<Examen, Integer> implements IExamenService{

    @Autowired
    private IExamenRepository repo;

    @Override
    protected JpaRepository<Examen, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Examen> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}
