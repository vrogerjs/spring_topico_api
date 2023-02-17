package regionancash.gob.pe.topico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.topico.model.Historiaclinica;
import regionancash.gob.pe.topico.model.Paciente;
import regionancash.gob.pe.topico.repository.IHistoriaclinicaRepository;
import regionancash.gob.pe.topico.service.IHistoriaclinicaService;

import java.util.List;

@Service
public class HistoriaclinicaServiceImpl extends CRUDImpl<Historiaclinica, Integer> implements IHistoriaclinicaService {

    @Autowired
    private IHistoriaclinicaRepository repo;

    @Override
    protected JpaRepository<Historiaclinica, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Historiaclinica> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public Page<Historiaclinica> findAllPaginationById(Integer Id,Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public List<Historiaclinica> getOneHistoriaclinica() {
        return repo.getOneHistoriaclinica();
    }

    @Override
    public Page<Historiaclinica> searchByParams(String search, Pageable page) {
        return repo.searchByParams(search, page);
    }
}
