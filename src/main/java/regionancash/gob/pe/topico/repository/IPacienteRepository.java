package regionancash.gob.pe.topico.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Paciente;

public interface IPacienteRepository extends IGenericRepo<Paciente, Integer> {
    @Query("SELECT p FROM Paciente p WHERE p.apeNomb LIKE CONCAT('%',:search,'%') OR p.nroDocumento LIKE CONCAT('%',:search,'%') OR p.modalidadContrato LIKE CONCAT('%',:search,'%') OR p.celular LIKE CONCAT('%',:search,'%') OR p.oficina.name LIKE CONCAT('%',:search,'%')")
    Page<Paciente> searchByParams(@Param("search") String search, Pageable page);
}
