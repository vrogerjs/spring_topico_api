package regionancash.gob.pe.topico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.topico.model.Oficina;
import regionancash.gob.pe.topico.repository.IGenericRepo;
import regionancash.gob.pe.topico.repository.IOficinaRepository;
import regionancash.gob.pe.topico.service.IOficinaService;


@Service
public class OficinaServiceImpl extends CRUDImpl<Oficina, Integer> implements IOficinaService {

    @Autowired
    private IOficinaRepository repo;

    @Override
    protected IGenericRepo<Oficina, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Oficina> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

}
