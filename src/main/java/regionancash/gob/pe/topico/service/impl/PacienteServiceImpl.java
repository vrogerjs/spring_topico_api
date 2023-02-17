package regionancash.gob.pe.topico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.topico.model.Historiaclinica;
import regionancash.gob.pe.topico.model.Paciente;
import regionancash.gob.pe.topico.repository.IHistoriaclinicaRepository;
import regionancash.gob.pe.topico.repository.IPacienteRepository;
import regionancash.gob.pe.topico.service.IPacienteService;

@Service
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer> implements IPacienteService {
    @Autowired
    private IPacienteRepository repo;

    @Override
    protected JpaRepository<Paciente, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Paciente> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public Page<Paciente> searchByParams(String search, Pageable page) {
        return repo.searchByParams(search, page);
    }
}
