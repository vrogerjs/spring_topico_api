package regionancash.gob.pe.topico.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.topico.model.Historiaclinica;
import regionancash.gob.pe.topico.model.Paciente;

import java.util.List;

public interface IHistoriaclinicaService extends ICRUD<Historiaclinica, Integer> {
    Page<Historiaclinica> findAllPagination(Pageable page);

    Page<Historiaclinica> findAllPaginationById(Integer Id,Pageable page);

    List<Historiaclinica> getOneHistoriaclinica();

    Page<Historiaclinica> searchByParams(String search, Pageable page);


}
