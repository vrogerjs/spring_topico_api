package regionancash.gob.pe.topico.repository;

import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.topico.model.Atencion;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IAtencionRepository extends IGenericRepo<Atencion, Integer> {
    @Query("SELECT a FROM Atencion a WHERE a.historiaclinica.id = :id")
    Page<Atencion> searchByIdHistoriaclinica(Pageable page, @Param("id") Integer IdHistoriaclinica);

    @Query("SELECT p.apeNomb, COUNT(a.historiaclinica.id) as cantidad FROM Atencion a " +
            "INNER JOIN a.historiaclinica hc " +
            "INNER JOIN hc.paciente p " +
            "WHERE a.fechaEvaluacion >= :fechaIni AND a.fechaEvaluacion <= :fechaFin " +
            "GROUP BY a.historiaclinica.id")
    List<Object[]> searchByRangoFechas(@Param("fechaIni") LocalDate fechaIni, @Param("fechaFin") LocalDate fechaFin);

    @Query("SELECT a FROM Atencion a where a.historiaclinica.paciente.nroDocumento= :nroDocumento")
    List<Atencion> searchByNroDocumento(@Param("nroDocumento") String nroDocumento);
}
