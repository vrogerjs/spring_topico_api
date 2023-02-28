package regionancash.gob.pe.topico.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Paciente;

import java.time.LocalDate;
import java.util.List;

public interface IPacienteRepository extends IGenericRepo<Paciente, Integer> {
    @Query("SELECT p FROM Paciente p WHERE p.apeNomb LIKE CONCAT('%',:search,'%') OR p.nroDocumento LIKE CONCAT('%',:search,'%') OR p.modalidadContrato LIKE CONCAT('%',:search,'%') OR p.celular LIKE CONCAT('%',:search,'%') OR p.oficina.name LIKE CONCAT('%',:search,'%')")
    Page<Paciente> searchByParams(@Param("search") String search, Pageable page);

    @Query("SELECT p FROM Paciente p WHERE p.modalidadContrato = :modalidadContrato")
    List<Paciente> searchByModalidadContrato(@Param("modalidadContrato") String modalidadContrato);

    @Query("SELECT DISTINCT p.modalidadContrato FROM Paciente p")
    List<String> ListByModalidadContrato();

    @Query("SELECT p FROM Paciente p WHERE (YEAR(CURDATE())-YEAR(p.fechaNacimiento)) >= :edadIni AND (YEAR(CURDATE())-YEAR(p.fechaNacimiento)) <= :edadFin ")
    List<Paciente> ListAllByEdad(@Param("edadIni") Integer edadIni, @Param("edadFin") Integer edadFin);
}
