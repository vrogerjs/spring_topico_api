package regionancash.gob.pe.topico.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.topico.model.Historiaclinica;
import regionancash.gob.pe.topico.model.Paciente;

import java.util.List;

public interface IHistoriaclinicaRepository extends IGenericRepo<Historiaclinica, Integer> {

    @Query("SELECT h FROM Historiaclinica h ORDER BY h.numero DESC LIMIT 1")
    List<Historiaclinica> getOneHistoriaclinica();

    @Query("SELECT h FROM Historiaclinica h WHERE h.numero LIKE CONCAT('%',:search,'%') OR h.paciente.apeNomb LIKE CONCAT('%',:search,'%') OR h.paciente.nroDocumento LIKE CONCAT('%',:search,'%') OR h.paciente.modalidadContrato LIKE CONCAT('%',:search,'%') OR h.paciente.celular LIKE CONCAT('%',:search,'%') OR h.paciente.oficina.name LIKE CONCAT('%',:search,'%')")
    Page<Historiaclinica> searchByParams(@Param("search") String search, Pageable page);
}
